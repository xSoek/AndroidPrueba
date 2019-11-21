package com.example.holaaplicacion.Database

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.holaaplicacion.Favourites.FavouriteMoviesAdapter
import com.example.holaaplicacion.List_Detail.MovieDetailActivity

interface LocalRepository {
     fun getAllMovies(view: View, favMoviesAdapter: FavouriteMoviesAdapter)
     fun insertMovie(favMovies: FavMovies, view: View)
     fun deleteAllMovies(view: View?,  favourite_recycler_view: RecyclerView)
     fun deleteOneMovie(selectedMovie: FavMovies, view: View)
}
