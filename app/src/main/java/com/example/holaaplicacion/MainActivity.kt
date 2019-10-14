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

import java.util.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var random: Int
        var number = 0


        val colors = arrayOf(GREEN, RED, BLUE, YELLOW, CYAN)
        val myText: TextView = findViewById(R.id.mainText)
        val myBtn: Button = findViewById(R.id.mainButton)
        val imageView = findViewById<ImageView>(R.id.mainImage)
        val imgId = R.drawable.img1

        var img = imgId

        imageView.setImageResource(img)


        Handler().postDelayed(Runnable {
            myText.text = "Pulsa el boton y veras qué pasa"
            myText.setTextColor(Color.RED)
        }, 2000)

        myBtn.setOnClickListener() {

            random = (0..4).random()
            number++
            if (number == 1)
                myText.text = "Has hecho click en el botón $number vez"
            else
                myText.text = "Has hecho click en el botón $number veces"
            myText.setTextColor(colors[random])

            Toast.makeText(MainActivity@ this, "Button pressed!", Toast.LENGTH_SHORT).show()

        }
    }
}
