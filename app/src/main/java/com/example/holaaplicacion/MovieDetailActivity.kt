package com.example.holaaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.holaaplicacion.model.Movie
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    val movie = Movie(
        id = 1,
        title = "Hola Mundo",
        year = "1996",
        genre = "Terror",
        description = "dsadsadasfadsfgvgsncugigueecruiiiiiiiiiiiicgfbrnsbxyvgerxbiafngywz",
        rate = 2
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        with (movie){
            titleText.text = title
            genreLabel.text = genre
            yearText.text = year
            descText.text = description
            rateText.text = rate.toString()

        }


    }
}
