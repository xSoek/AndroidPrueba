package com.example.holaaplicacion.Database

import androidx.room.*



//El Dao posee todas las queries de la app
@Dao
interface moviesDao {

    @Query("SELECT * FROM `favourite_movies_database`")
    suspend fun getMovies(): List<FavMovies>

    @Query("SELECT * FROM `favourite_movies_database` order by date_Inserted DESC ")
    suspend fun getMoviesByDate(): List<FavMovies>

    @Query("SELECT * FROM `favourite_movies_database` order by title ")
    suspend fun getMoviesByName(): List<FavMovies>

    @Query("SELECT count(id) FROM `favourite_movies_database` WHERE id = :movieId")
    suspend fun isInFavourites(movieId: Int): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movie: FavMovies)

    @Delete
    suspend fun deleteMovie(movie: FavMovies)

    @Query("DELETE FROM favourite_movies_database")
    suspend fun  deleteAllMovies()

}
