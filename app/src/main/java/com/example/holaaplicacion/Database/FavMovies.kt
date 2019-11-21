package com.example.holaaplicacion.Database

import androidx.room.*
import com.example.holaaplicacion.model.DatabaseMovie
import com.example.holaaplicacion.model.Genre
import com.example.holaaplicacion.model.Movie
import java.sql.Date
import java.sql.Time
import java.time.LocalDate
import java.util.*


@Entity(tableName = "favourite_movies_database")
data class FavMovies(

    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "original title")
    val original_title: String?,

    @ColumnInfo(name = "release date")
    val release_date: String?,

    @ColumnInfo(name = "vote average")
    val vote_average: Double?,

    @ColumnInfo(name = "poster path")
    val poster_path: String?
)

