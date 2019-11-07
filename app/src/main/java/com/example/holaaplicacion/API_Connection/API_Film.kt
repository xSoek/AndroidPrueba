package com.example.holaaplicacion.API_Connection


import com.example.holaaplicacion.model.*
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    @GET("search/movie?")
    suspend fun searchMovies(@Query("api_key") apiKey: String, @Query("query") movie: String): Response<MovieResponse>

    @GET("movie/{id}?")
    suspend fun getMovieDetail(@Path("id") id: Int, @Query("api_key") api_key: String): Response<Movie>

    @GET("movie/{id}/credits?")
    suspend fun getMovieCast(@Path("id") id: Int, @Query("api_key") api_key: String): Response<Credits>

   /* @GET("/api/location/{id}/")
    suspend fun getCityDetail(@Path("id") cityId: Int?): Response<WeatherResponse>
*/
}


object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApi::class.java)
    }
}