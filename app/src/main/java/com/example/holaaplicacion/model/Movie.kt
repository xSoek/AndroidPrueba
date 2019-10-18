package com.example.holaaplicacion.model

import android.media.Image

data class Movie(

    val popularity: Int,
    val vote_count: Int,
    val video: Boolean,
    val poster_path: String,
    val id: Int,
    val adult: Boolean,
    val backdrop_path: String,
    val original_language: String,
    val original_title: String,
    val genre_ids: Array<Int>,
    val title: String,
    val vote_average: Double,
    val overview: String,
    val release_date: String
)