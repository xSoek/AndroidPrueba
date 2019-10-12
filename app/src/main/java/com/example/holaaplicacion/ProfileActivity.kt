package com.example.holaaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val name = intent.extras?.getString("name")
        val city = intent.extras?.getString("city")
        val date = intent.extras?.getString("date")
        val image = intent.extras?.getInt("image")
        val desc = intent.extras?.getString("description")
        nametxt.text = name
        citytxt.text = city
        birthDatetxt.text = date
        descriptionText.text = desc
        if (image != null) {
            profileImage.setImageResource(image)
        }
    }
}
