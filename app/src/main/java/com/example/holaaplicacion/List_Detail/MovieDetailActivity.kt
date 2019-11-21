package com.example.holaaplicacion.List_Detail

import android.os.AsyncTask
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.example.holaaplicacion.Database.AppDataBase
import com.example.holaaplicacion.Database.FavMovies
import com.example.holaaplicacion.Favourites.BaseFragment
import com.example.holaaplicacion.Favourites.FavouriteMoviesList
import com.example.holaaplicacion.Favourites.FavouritePresenter
import com.example.holaaplicacion.R
import com.example.holaaplicacion.model.Cast
import com.example.holaaplicacion.model.Crew
import com.example.holaaplicacion.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_favourite_movies.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class MovieDetailActivity : AppCompatActivity(), FavouritePresenter.FavouriteView {

    private var isAdded: Boolean = false
    private var favList = FavouriteMoviesList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_detail)
        setMovieDetail()
        val presenter = FavouritePresenter(this)

        CoroutineScope(Dispatchers.IO).launch {
            baseContext?.let {
                if( AppDataBase.invoke(it).getMoviesDao().isInFavourites(intent.extras!!.getInt("id"))==1){
                    imgFav.setImageResource(R.drawable.star_on)
                    isAdded = true
                }
            }
        }

        imgFav.setOnClickListener {


            val selectedMovie = FavMovies(
                intent.extras!!.getInt("id"),
                intent.extras?.getString("title"),
                intent.extras?.getString("original_title"),
                intent.extras?.getString("release_date"),
                intent.extras?.getDouble("vote_average"),
                intent.extras?.getString("poster_path")
            )
            println("ME HAN PINCHADO!!!!")
            if (!isAdded) {
                presenter.insertMovie(selectedMovie, it)
                imgFav.setImageResource(R.drawable.star_on)
                isAdded = true

            } else if (isAdded) {
                presenter.deleteOneMovie(selectedMovie, it)
                imgFav.setImageResource(R.drawable.star_off)

                isAdded = false

            }

        }
    }

    //Recibe los datos de la pelicula enviados desde el MovieSearcher
    fun setMovieDetail() {

        titleText.text = intent.extras?.getString("title")
        descText.text = intent.extras?.getString("overview")
        rateText.text = intent.extras?.getDouble("vote_average").toString()
        yearText.text = intent.extras?.getString("release_date")
        directorText.text = intent.extras?.getString("name")
        actorText.text = intent.extras?.getString("castNames")!!.substring(
            0,
            deleteLastComa(intent.extras?.getString("castNames")!!.length)
        )
        genreText.text = intent.extras?.getString("genreNames")!!.substring(
            0,
            deleteLastComa(intent.extras?.getString("genreNames")!!.length)
        )
        Picasso.get()
            .load("http://image.tmdb.org/t/p/original/" + intent.extras?.getString("backdrop_path"))
            .into(photo)

    }

    //Función improvisada para quitar las comas sobrantes
    fun deleteLastComa(field: Int): Int {
        val delete = field - 2
        return delete
    }

    override fun openMovieDetail(movie: Movie, director: MutableList<Crew>, casting: MutableList<Cast>) {

    }


}
