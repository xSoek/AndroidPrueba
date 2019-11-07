package com.example.holaaplicacion.model

data class Credits (
    val id: Int,
    val cast: MutableList<Cast>,
    val crew: MutableList<Crew>
)

data class Crew(
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val name: String,
    val profile_path: String
)


data class Cast(
    val cast_id: Int,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val profile_path: String
)