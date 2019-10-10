package com.example.holaaplicacion

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var myText : TextView
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myText =  findViewById(R.id.mainText)
        var random: Int
        var number = 0


        val colors = arrayOf(GREEN, RED, BLUE, YELLOW, CYAN)

        val myBtn: Button = findViewById(R.id.mainButton)
        val imageView = findViewById<ImageView>(R.id.mainImage)
       // val imgId = R.drawable.img1

        //var img = imgId

       // imageView.setImageResource(img)
        Handler().postDelayed(Runnable {
            myText.text = "Pulsa el boton y veras qué pasa"
            myText.setTextColor(Color.RED)
        }, 2000)

        myBtn.setOnClickListener() {

            random = (0..4).random()
            number++
            val time: String = "time"
            val message = getString(R.string.button_pressed, number, time)
            if (number == 1)
                myText.text = message
            else
                myText.text = message
            myText.setTextColor(colors[random])

            Toast.makeText(MainActivity@ this, "Button pressed!", Toast.LENGTH_SHORT).show()

        }
    }


}