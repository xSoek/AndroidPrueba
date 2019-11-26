package com.example.holaaplicacion.Favourites

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.Database.FavMovies
import com.example.holaaplicacion.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_movie_list.view.*


class FavouriteMoviesAdapter(val listener: (FavMovies) -> Unit) : RecyclerView.Adapter<FavouriteMoviesAdapter.MovieViewHolder>(){

    private var movies = listOf<FavMovies>()

    fun addMovies(newMovies: List<FavMovies>) {
        this.movies = newMovies
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val myMovie = movies.get(position)
        holder.bind(myMovie, listener)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title = itemView.labelTitle
        var orgTitle = itemView.labelOriginalTitle
        var date = itemView.labelDate
        var rate = itemView.labelRate
        var img1 = itemView.labelImg


        fun bind (movie: FavMovies, listener: (FavMovies) -> Unit){
            title.text = movie.title
            orgTitle.text = movie.original_title
            date.text = movie.release_date
            rate.text = movie.vote_average.toString()
            Picasso.get().load("http://image.tmdb.org/t/p/w200/" + movie.poster_path).into(img1)
            this.itemView.setOnClickListener{listener.invoke(movie)}
        }

        companion object {
            fun from(parent: ViewGroup): MovieViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.fragment_movie_list, parent, false)
                return MovieViewHolder(view)
            }
        }

    }

}