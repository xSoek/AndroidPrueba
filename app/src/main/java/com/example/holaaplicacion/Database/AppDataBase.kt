package com.example.holaaplicacion.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


//Creacion de la Entity y la Database

@Database(entities = [FavMovies::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getMoviesDao(): moviesDao

    companion object {
        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDataBase::class.java,
            "moviedatabase"
        ).build()
    }
}
