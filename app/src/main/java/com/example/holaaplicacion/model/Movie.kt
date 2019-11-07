package com.example.holaaplicacion.model

data class Movie(

    val popularity: String,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genres: Array<Genre>,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
)
data class Genre(

    var id: Int,
    var name: String
)

data class MovieResponse(

    var page: Int,
    var total_pages: Int,
    var results: MutableList<Movie>
)