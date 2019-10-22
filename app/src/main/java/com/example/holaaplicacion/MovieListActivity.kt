package com.example.holaaplicacion

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.holaaplicacion.model.Movie
import kotlinx.android.synthetic.main.activity_recycle_view.*

private lateinit var MovieList: MovieActivityList
val movieList = mutableListOf<Movie>()

class MovieActivityList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)
        createMovieList()
        createRecyclerView()
    }

    fun createMovieList() {
        for (number in 1 until 4) {
            movieList.add(movie1)
            movieList.add(movie2)
            movieList.add(movie3)
        }

    }

    fun createRecyclerView() {
        activity_recycle_viewid.layoutManager = LinearLayoutManager(this)
        activity_recycle_viewid.adapter =
            MovieAdapter(movieList, { toast(String.format("Titulo %s", it.title), duration = 500) })
    }

    fun Activity.toast(text: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this@MovieActivityList, text, duration).show()
    }

    val movie1 = Movie(
        popularity = 17188,
        vote_count = 3467,
        video = false,
        poster_path = "http://www.filmandtvnow.com/wp-content/uploads/2017/02/Transformers-5-The-Last-Knight-Online-Trailer.jpg",
        id = 335988,
        adult = false,
        backdrop_path = "/1n00NlOGRFZVs8coBxyZLm5l4EC.jpg",
        original_language = "en",
        original_title = "Transformers: The Last Knight",
        genre_ids = arrayOf(28, 12, 878, 53),
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
        poster_path = "https://i1.wp.com/www.sopitas.com/wp-content/uploads/2014/05/optimusimax-640x581.jpg",
        id = 91314,
        adult = false,
        backdrop_path = "",
        original_language = "en",
        original_title = "Transformers: Age of Extinction",
        genre_ids = arrayOf(28, 12, 878),
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
        poster_path = "http://facesonthebox.com/wp-content/uploads/trans1.jpg",
        id = 1858,
        adult = false,
        backdrop_path = "/qMg2eSEnPrqT6uBjrLTzqzP2sHp.jpg",
        original_language = "en",
        original_title = "Transformers",
        genre_ids = arrayOf(28, 12, 878),
        title = "Transformers",
        vote_average = 6.7,
        overview = "Young teenager, Sam Witwicky becomes involved in the ancient struggle between two " +
                "extraterrestrial factions of transforming robots – the heroic Autobots and the evil Decepticons. " +
                "Sam holds the clue to unimaginable power and the Decepticons will stop at nothing to retrieve it.",
        release_date = "2007-07-02"
    )

}
