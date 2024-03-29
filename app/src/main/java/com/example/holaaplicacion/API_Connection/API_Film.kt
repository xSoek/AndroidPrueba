package com.example.holaaplicacion.API_Connection


import com.example.holaaplicacion.List_Detail.MovieListActivity
import com.example.holaaplicacion.model.*
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    // Query -> selecciona todas las peliculas con un string similar al introducido por parametro
    @GET("search/movie?")
    suspend fun searchMovies(@Query("api_key") apiKey: String, @Query("query") movie: String): Response<MovieResponse>

    // Query -> selecciona la pelicula indicada por parametro para mostrar su info
    @GET("movie/{id}?")
    suspend fun getMovieDetail(@Path("id") id: Int, @Query("api_key") api_key: String): Response<Movie>

    // Query -> selecciona la pelicula indicada por parametro para mostrar sus créditos
    @GET("movie/{id}/credits?")
    suspend fun getMovieCast(@Path("id") id: Int, @Query("api_key") api_key: String): Response<Credits>

}


//Creación del Retrofit
object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"

    fun getMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(MovieApi::class.java)
    }
    //val devbytes = retrofit.create(DevbyteService::class.java)
}

/*interface DevbyteService {
    @GET("devbytes")
    fun getPlaylist(): Deferred<NetworkVideoContainer>
}*/