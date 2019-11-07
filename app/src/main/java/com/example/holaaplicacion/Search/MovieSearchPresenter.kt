package com.example.holaaplicacion.Search

import com.example.holaaplicacion.API_Connection.RetrofitFactory
import com.example.holaaplicacion.model.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: MovieSearchView) {

    fun searchClicked(apiKey: String, movieName: String) {

        if (apiKey.isEmpty()) {
            return
        }

        val movieApi = RetrofitFactory.getMovieApi()
        CoroutineScope(Dispatchers.IO).launch {

            val response = movieApi.searchMovies(apiKey, movieName)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val movies = response.body()
                    view.showMovies(movies!!.results)
                }
            }
        }
    }

    fun movieClicked(id: Int, apiKey: String) {
        val movieApi = RetrofitFactory.getMovieApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = movieApi.getMovieDetail(id, apiKey)
            val responseCast = movieApi.getMovieCast(id, apiKey)
            var movies = response.body()
            var castDirector = responseCast.body()
            if (response.isSuccessful) {
                view.openMovieDetail(movies!!, castDirector!!.crew, castDirector!!.cast)
            }
        }
    }

    interface MovieSearchView {
        fun showMovies(movies: List<Movie>)
        fun openMovieDetail(movie: Movie, director: MutableList<Crew>, casting: MutableList<Cast>)
        fun showEmpty()
    }
}