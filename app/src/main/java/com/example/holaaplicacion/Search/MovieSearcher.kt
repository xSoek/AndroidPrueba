package com.example.holaaplicacion.Search

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.List_Detail.MovieDetailActivity
import com.example.holaaplicacion.R
import com.example.holaaplicacion.model.*
import kotlinx.android.synthetic.main.fragment_movie_searcher.*

class MovieSearcher : Fragment(), MovieSearchPresenter.MovieSearchView {

    lateinit var moviesAdapter: MovieAdapter
    val apiKey = "78fa5a012cc429b291d89251d98e9f0e"
    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_searcher, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val presenter = MovieSearchPresenter(this)

        film_recycler_view.layoutManager = LinearLayoutManager(activity) as RecyclerView.LayoutManager?
        film_recycler_view.setHasFixedSize(true)
        moviesAdapter = MovieAdapter {

            //Cuando hacemos click en una de las peliculas de la lista, cogemos su Id y lo pasamos por parametro al presenter
            presenter.movieClicked(it.id, apiKey)
        }

        film_recycler_view.adapter = moviesAdapter

        //Cuando hacemos Click en el boton de buscar, enviamos el nombre de la pelicula por parametro al presenter
        search.setOnClickListener {

            val movieName = filmSearchedTxt.text.toString()
            presenter.searchClicked(apiKey, movieName)
        }
    }

    override fun showMovies(movies: List<Movie>) {
        moviesAdapter.addMovies(movies)
        film_recycler_view.visibility = View.VISIBLE
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

    override fun showEmpty() {
        film_recycler_view.visibility = View.GONE
    }
}