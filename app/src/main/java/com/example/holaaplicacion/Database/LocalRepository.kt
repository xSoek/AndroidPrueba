package com.example.holaaplicacion.Database

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.Favourites.FavouriteMoviesAdapter


//Creacion del LocalRepository
interface LocalRepository {
     fun getAllMovies(view: View, favMoviesAdapter: FavouriteMoviesAdapter)
     fun getAllMoviesByDate(view: View, favMoviesAdapter: FavouriteMoviesAdapter)
     fun getAllMoviesByName(view: View, favMoviesAdapter: FavouriteMoviesAdapter)
     fun insertMovie(favMovies: FavMovies, view: View)
     fun deleteAllMovies(view: View?, favourite_recycler_view: RecyclerView)
     fun deleteOneMovie(selectedMovie: FavMovies, view: View, adapter: FavouriteMoviesAdapter)
}
