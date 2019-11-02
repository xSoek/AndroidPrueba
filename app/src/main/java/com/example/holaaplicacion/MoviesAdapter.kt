package com.example.holaaplicacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.holaaplicacion.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_list.view.*


class MovieAdapter( val items: List<Movie>, val listener: (Movie) -> Unit)
    :RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
   return MovieViewHolder(LayoutInflater.from(parent.context)
       .inflate(R.layout.activity_movie_list, parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = items.get(position)
        holder.title.text = movie.title
        holder.orgTitle.text = movie.original_title
        holder.date.text = movie.release_date

        holder.rate.text = movie.vote_average.toString()
        Picasso.get().load(movie.poster_path).into(holder.img1)
        holder.itemView.setOnClickListener(){

            listener(movie)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var title = itemView.labelTitle
        var orgTitle = itemView.labelOriginalTitle
        var date = itemView.labelDate
        var rate = itemView.labelRate
        var img1 = itemView.labelImg


    }

}