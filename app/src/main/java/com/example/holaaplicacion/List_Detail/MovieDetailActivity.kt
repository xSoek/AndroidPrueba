package com.example.holaaplicacion.List_Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holaaplicacion.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_detail.*


class MovieDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_movie_detail)
        setMovieDetail()
    }

    fun setMovieDetail(){

        titleText.text = intent.extras?.getString("title")
        descText.text = intent.extras?.getString("overview")
        rateText.text = intent.extras?.getDouble("vote_average").toString()
        yearText.text = intent.extras?.getString("release_date")
        directorText.text = intent.extras?.getString("name")
        actorText.text = intent.extras?.getString("castNames")!!.substring(0, deleteLastComa(intent.extras?.getString("castNames")!!.length))
        genreText.text = intent.extras?.getString("genreNames")!!.substring(0, deleteLastComa(intent.extras?.getString("genreNames")!!.length))
        Picasso.get().load("http://image.tmdb.org/t/p/original/" + intent.extras?.getString("backdrop_path")).into(photo)

    }

    fun deleteLastComa(field: Int): Int{
        val delete = field - 2
        return delete
    }
}
