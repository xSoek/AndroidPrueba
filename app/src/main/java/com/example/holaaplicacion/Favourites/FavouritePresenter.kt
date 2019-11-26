package com.example.holaaplicacion.Favourites

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.API_Connection.RetrofitFactory
import com.example.holaaplicacion.Database.AppDataBase
import com.example.holaaplicacion.Database.FavMovies
import com.example.holaaplicacion.Database.LocalRepository
import com.example.holaaplicacion.model.Cast
import com.example.holaaplicacion.model.Crew
import com.example.holaaplicacion.model.Movie
import kotlinx.coroutines.*

class FavouritePresenter(private val view: FavouriteView) : LocalRepository {

    //Borra la pelicula que esta añadida en favoritos, mediante corutinas
    override fun deleteOneMovie(selectedMovie: FavMovies, view: View, adapter: FavouriteMoviesAdapter) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                AppDataBase.invoke(view.context).getMoviesDao().deleteMovie(selectedMovie)
                val notDeleted =  AppDataBase.invoke(view!!.context).getMoviesDao().getMovies()
                println(notDeleted)
                adapter.addMovies(notDeleted)
            }
        }
    }


    //Borra todas las peliculas (Opcion del Menú), mediante corutinas
    override fun deleteAllMovies(view: View?, favourite_recycler_view: RecyclerView) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                AppDataBase.invoke(view!!.context).getMoviesDao().deleteAllMovies()
            }
        }
    }

    //Muestra todas las peliculas estan añadidas en favoritos, mediante corutinas
    override fun getAllMovies(view: View, favMoviesAdapter: FavouriteMoviesAdapter) {
        CoroutineScope(Dispatchers.IO).launch {
            val myMovies = AppDataBase.invoke(view.context).getMoviesDao().getMovies()
            withContext(Dispatchers.Main) {
                favMoviesAdapter.addMovies(myMovies)
                println(myMovies)
            }
        }
    }

    override fun getAllMoviesByDate(view: View, favMoviesAdapter: FavouriteMoviesAdapter) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                val myMovies = AppDataBase.invoke(view.context).getMoviesDao().getMoviesByDate()
                favMoviesAdapter.addMovies(myMovies)
                println(myMovies)
            }
        }
    }

    override fun getAllMoviesByName(view: View, favMoviesAdapter: FavouriteMoviesAdapter) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                val myMovies = AppDataBase.invoke(view.context).getMoviesDao().getMoviesByName()
                favMoviesAdapter.addMovies(myMovies)
                println(myMovies)
            }
        }
    }

    //Inserta una pelicula a favoritos, mediante corutinas
    override fun insertMovie(favMovies: FavMovies, view: View) {
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                AppDataBase.invoke(view.context).getMoviesDao().insertMovie(favMovies)
                println("MOVIE addded")
            }
        }
    }

    fun movieClicked(id: Int, apiKey: String) {
        val movieApi = RetrofitFactory.getMovieApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = movieApi.getMovieDetail(id, apiKey)
            val responseCast = movieApi.getMovieCast(id, apiKey)
            val movies = response.body()
            val castDirector = responseCast.body()
            println(movieApi)
            println(response)
            //Si no ha ocurrido ningún error inesperado, le pasaremos el response por parametro a la view,
            // que se encargara de separar la info de la pelicula, el casting de actores y el director y enviarselo al MovieDetailActivity
            if (response.isSuccessful) {
                view.openMovieDetail(movies!!, castDirector!!.crew, castDirector.cast)
            }
        }
    }

    interface FavouriteView {

        fun openMovieDetail(movie: Movie, director: MutableList<Crew>, casting: MutableList<Cast>)
    }
}

