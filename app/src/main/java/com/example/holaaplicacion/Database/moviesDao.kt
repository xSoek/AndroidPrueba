package com.example.holaaplicacion.Database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.holaaplicacion.model.DatabaseMovie
import com.example.holaaplicacion.model.Movie

@Dao
interface moviesDao {

    @Query("SELECT * FROM `favourite_movies_database`")
    suspend fun getMovies(): List<FavMovies>

    /*@Query("SELECT * FROM `favourite_movies_database` order by `date added` ")
    suspend fun getMoviesByDate(): List<FavMovies>*/

    @Query("SELECT count(id) FROM `favourite_movies_database` WHERE id = :movieId")
    suspend fun isInFavourites(movieId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: FavMovies)

    @Delete
    suspend fun deleteMovie(movie: FavMovies)

    @Query("DELETE FROM favourite_movies_database")
    suspend fun  deleteAllMovies()

}
