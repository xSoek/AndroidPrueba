package com.example.holaaplicacion

import android.annotation.SuppressLint
import android.content.Intent
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
    private lateinit var myText: TextView
    private lateinit var buttonProf: Button
    private lateinit var buttonMovie: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myText = findViewById(R.id.mainText)
        buttonProf = findViewById(R.id.buttonProf)
        buttonMovie = findViewById(R.id.buttonMovie)
        var random: Int
        var number = 0


        val colors = arrayOf(GREEN, RED, BLUE, YELLOW, CYAN)

        val myBtn: Button = findViewById(R.id.mainButton)
        val imageView = findViewById<ImageView>(R.id.mainImage)
        val imgId = R.drawable.img1

        var img = imgId

        imageView.setImageResource(img)

        /* Eliminado por aviso del profesor (Puede petar la app)
        Handler().postDelayed(Runnable {
            myText.text = "Pulsa el boton y veras qué pasa"
            myText.setTextColor(Color.RED)
        }, 2000)*/

        buttonProf.setOnClickListener() {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("name", "Jorge de Paz")
            intent.putExtra("date", "08/07/1999")
            intent.putExtra("city", "Madrid")
            intent.putExtra("hobby", "Videojuegos, Nadar")
            intent.putExtra("color", "Verde")
            intent.putExtra("image", R.drawable.profileimg)
            intent.putExtra("description", "Joven programador, su interes por las tecnologías apareció cuando comenzó a " +
                    "jugar videojuegos a los 5 años, después con el tiempo fue interesandose en cómo funcionaba, cómo se movían los " +
                    " personajes, cómo se cambiaba entre las animaciones de los personajes, etc.. Lo que hizo que entrara en el mundo " +
                    "de la programación, primero haciendo un grado en Ingernieria de Computadores, luego en una ciclo de Desarrollo de" +
                    " Aplicaciones Multplataforma (DAM) y luego un Máster en Desarrollo de Videojuegos")
            startActivity(intent)

            //Imagen a PASAR
        }

        buttonMovie.setOnClickListener(){
            val intent = Intent(this, MovieDetailActivity::class.java)
            startActivity(intent)
        }

        myBtn.setOnClickListener() {

            random = (0..4).random()
            number++
            var message = ""
            if (number == 1) {
                message = getString(R.string.button_pressed, number)
                myText.text = message
            }else{
                message = getString(R.string.button_pressedM1, number)
                myText.text = message
            }
            myText.setTextColor(colors[random])

            Toast.makeText(MainActivity@ this, "Button pressed!", Toast.LENGTH_SHORT).show()

        }
    }


}