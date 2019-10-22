package com.example.holaaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.holaaplicacion.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_detail.*

class MovieDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
       /* with (movie1){
            Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(photo);
            titleText.text = title
            genreLabel.text = original_language
            yearText.text = release_date
            descText.text = overview
            rateText.text = vote_average.toString()

        }*/
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
