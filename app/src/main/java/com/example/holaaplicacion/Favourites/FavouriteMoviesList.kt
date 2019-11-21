package com.example.holaaplicacion.Favourites

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.core.view.get
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.Database.AppDataBase
import com.example.holaaplicacion.Database.FavMovies
import com.example.holaaplicacion.List_Detail.MovieDetailActivity
import com.example.holaaplicacion.R
import com.example.holaaplicacion.Search.MovieAdapter
import com.example.holaaplicacion.model.Cast
import com.example.holaaplicacion.model.Crew
import com.example.holaaplicacion.model.Movie
import kotlinx.android.synthetic.main.fragment_favourite_movies.*
import kotlinx.android.synthetic.main.fragment_movie_list.*
import kotlinx.android.synthetic.main.fragment_movie_list.view.*
import kotlinx.android.synthetic.main.fragment_movie_searcher.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FavouriteMoviesList : BaseFragment(), FavouritePresenter.FavouriteView {
    lateinit var favMoviesAdapter: FavouriteMoviesAdapter
    val presenter = FavouritePresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_favourite_movies, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favourite_recycler_view.setHasFixedSize(true)
        favourite_recycler_view.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?


        favMoviesAdapter = FavouriteMoviesAdapter {
            //Cuando hacemos click en una de las peliculas de la lista de Favoritos, cogemos su Id y lo pasamos por parametro al presenter
            println(it.id)
            presenter.movieClicked(it.id, "78fa5a012cc429b291d89251d98e9f0e")
        }


        favourite_recycler_view.adapter = favMoviesAdapter
        presenter.getAllMovies(view, favMoviesAdapter)
    }


    private fun deleteAllMovies(){
       presenter.deleteAllMovies(this.view, favourite_recycler_view)
    }

    private fun orderByDate(){
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                //AppDataBase.invoke(view!!.context).getMoviesDao().getMoviesByDate()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.deleteAll -> deleteAllMovies()
            R.id.ordDate -> orderByDate()
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.favourite_menu, menu)
    }

    override fun openMovieDetail(movie: Movie, director: MutableList<Crew>, casting: MutableList<Cast>) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        val genresSize  = movie.genres.size
        val castingSize  = casting.size

        var castName = ""
        var genreName = ""


        //Enviamos toda la informacion al MovieDetailActivity
        intent.putExtra("id", movie.id)
        intent.putExtra("poster_path", movie.poster_path)
        intent.putExtra("original_title", movie.original_title)
        intent.putExtra("title", movie.title)
        intent.putExtra("release_date", movie.release_date)
        intent.putExtra("vote_average", movie.vote_average)
        intent.putExtra("overview", movie.overview)
        intent.putExtra("backdrop_path", movie.backdrop_path)


        //Recorre la lista en busca del Director de la pelicula
        for (directors in director){
            if(directors.job.equals("Director")) {
                val dirName = directors.name
                intent.putExtra("name", dirName)
            }
        }

        //Recorre el Array y muestra tan solo dos generos de la pelicula
        for (x in 0 until genresSize) {
            if(x<2) {
                genreName += movie.genres[x].name + ", "
                intent.putExtra("genreNames", genreName)
            }
        }

        //Recorre el Array y muestra tan solo 3 actores de la pelicula
        for (x in 0 until castingSize) {
            if (x<=2) {
                castName += casting[x].name + ", "
                intent.putExtra("castNames", castName)
            }
        }
        startActivity(intent)
    }


}
