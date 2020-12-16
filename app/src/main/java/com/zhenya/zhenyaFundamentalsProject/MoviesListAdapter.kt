package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MoviesListAdapter(context: Context, var movies: List<Movie>, val clickListener: ClickListenerInterface) : RecyclerView.Adapter<MoviesListViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        return MoviesListViewHolder(inflater.inflate(R.layout.view_holder_movie_card, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickListener.movieCardPressed()
        }
    }

    override fun getItemCount(): Int = movies.size

    private fun getItem(position: Int): Movie = movies[position]


}