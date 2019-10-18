package com.example.holaaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.holaaplicacion.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {

    val movie1 = Movie(
        popularity = 17188,
        vote_count = 3467,
        video = false,
        poster_path = "/s5HQf2Gb3lIO2cRcFwNL9sn1o1o.jpg",
        id = 335988,
        adult = false,
        backdrop_path =  "/1n00NlOGRFZVs8coBxyZLm5l4EC.jpg",
        original_language = "en",
        original_title = "Transformers: The Last Knight",
        genre_ids = arrayOf(28,12,878,53),
        title = "Transformers: The Last Knight",
        vote_average = 6.0,
        overview = "Autobots and Decepticons are at war, with humans on the sidelines. " +
                "Optimus Prime is gone. The key to saving our future lies buried in the secrets " +
                "of the past, in the hidden history of Transformers on Earth.",
        release_date = "2017-06-21"
        )
    val movie2 = Movie(
        popularity = 18328,
        vote_count = 5055,
        video = false,
        poster_path = "/ykIZB9dYBIKV13k5igGFncT5th6.jpg",
        id = 91314,
        adult = false,
        backdrop_path =  "/cHy7nSitAVgvZ7qfCK4JO47t3oZ.jpg",
        original_language = "en",
        original_title = "Transformers: Age of Extinction",
        genre_ids = arrayOf(28,12,878),
        title = "Transformers: Age of Extinction",
        vote_average = 5.8,
        overview = "As humanity picks up the pieces, following the " +
                "conclusion of Transformers: Dark of the Moon, Autobots " +
                "and Decepticons have all but vanished from the face of the " +
                "planet. However, a group of powerful, ingenious businessman and " +
                "scientists attempt to learn from past Transformer incursions and push " +
                "the boundaries of technology beyond what they can control - all while an ancient, " +
                "powerful Transformer menace sets Earth in his cross-hairs.",
        release_date = "2014-06-27"
    )
    val movie3 = Movie(
        popularity = 4356,
        vote_count = 6927,
        video = false,
        poster_path = "/bgSHbGEA1OM6qDs3Qba4VlSZsNG.jpg",
        id = 1858,
        adult = false,
        backdrop_path =  "/qMg2eSEnPrqT6uBjrLTzqzP2sHp.jpg",
        original_language = "en",
        original_title = "Transformers",
        genre_ids = arrayOf(28,12,878),
        title = "Transformers",
        vote_average = 6.7,
        overview = "Young teenager, Sam Witwicky becomes involved in the ancient struggle between two " +
                "extraterrestrial factions of transforming robots – the heroic Autobots and the evil Decepticons. " +
                "Sam holds the clue to unimaginable power and the Decepticons will stop at nothing to retrieve it.",
        release_date = "2007-07-02"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        with (movie1){
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(photo);
            titleText.text = title
            genreLabel.text = original_language
            yearText.text = release_date
            descText.text = overview
            rateText.text = vote_average.toString()

        }
        Log.e("miTag0.1","error0.2")
    }




    override fun onStart() {
        super.onStart()
        Log.e("miTag1.1","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("miTag2.1","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("miTag3.1","onPasue")
    }

    override fun onStop() {
        super.onStop()
        Log.e("miTag4.1","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("miTag5.1","onDestroy")
    }

}
