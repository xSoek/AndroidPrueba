package com.example.holaaplicacion

import android.content.Intent
import android.graphics.Color.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.model.Movie
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recycle_view.*


class MainActivity : AppCompatActivity() {
    private lateinit var myText: TextView
    private lateinit var buttonProf: Button
    private lateinit var buttonMovie: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myText = findViewById(R.id.mainText)
        buttonProf = findViewById(R.id.buttonProf)
        buttonMovie = findViewById(R.id.buttonMovie)
        viewManager = LinearLayoutManager(this)


        Log.e("miTag0.1","error0.1")
        var random: Int
        var number = 0
        var APIKEY = "78fa5a012cc429b291d89251d98e9f0e"

        val colors = arrayOf(GREEN, RED, BLUE, YELLOW, CYAN)

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

            //Imagen a PASAR
        }

        buttonMovie.setOnClickListener(){
            val intent = Intent(this, MovieActivityList::class.java)
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


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("savText", myText.getText().toString());

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        myText.setText(savedInstanceState.getString("savText"))
        //restore it using the key

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
        Log.e("miTag3.1","onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("miTag4.1","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("miTag5.1","error5.1")
    }




}