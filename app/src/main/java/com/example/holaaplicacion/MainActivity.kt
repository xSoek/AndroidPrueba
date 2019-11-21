package com.example.holaaplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)
        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.fragment_movie_list, R.id.fragment_favourite_movie, R.id.fragment_activity_profile))

        bottomNavigationView.setupWithNavController(navController)
        setupActionBarWithNavController(findNavController(R.id.fragment), appBarConfiguration)

    }
}