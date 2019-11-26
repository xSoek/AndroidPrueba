package com.example.holaaplicacion


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


import java.util.*



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myText = findViewById(R.id.mainText)
        buttonProf = findViewById(R.id.buttonProf)
        buttonMovie = findViewById(R.id.buttonMovie)
        viewManager = LinearLayoutManager(this)


        var random: Int
        var number = 0
        var APIKEY = "78fa5a012cc429b291d89251d98e9f0e"

        val colors = arrayOf(GREEN, RED, BLUE, YELLOW, CYAN)

        val myText: TextView = findViewById(R.id.mainText)

        val myBtn: Button = findViewById(R.id.mainButton)
        val imageView = findViewById<ImageView>(R.id.mainImage)
        val imgId = R.drawable.img1

        var img = imgId

        imageView.setImageResource(img)

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
        }

        val navController = findNavController(R.id.fragment)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.fragment_movie_list, R.id.fragment_favourite_movie, R.id.fragment_activity_profile))

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(findNavController(R.id.fragment), appBarConfiguration)

    }

}