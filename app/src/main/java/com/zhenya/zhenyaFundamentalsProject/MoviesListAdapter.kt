package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.ornolfr.ratingview.RatingView


class MoviesListAdapter(context: Context?, var movies: List<Movie>, val clickListener: ClickListenerInterface?) : RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        return MoviesListViewHolder(inflater.inflate(R.layout.view_holder_movie_card, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            clickListener?.movieCardPressed()
        }
    }

    override fun getItemCount(): Int = movies.size

    private fun getItem(position: Int): Movie = movies[position]

    inner class MoviesListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var age = itemView.findViewById<TextView>(R.id.card_age)
        private var like = itemView.findViewById<ImageView>(R.id.like)
        private var poster = itemView.findViewById<ImageView>(R.id.card_poster)
        private var genre = itemView.findViewById<TextView>(R.id.card_genre)
        private var rating = itemView.findViewById<RatingView>(R.id.rating)
        private var reviewCount = itemView.findViewById<TextView>(R.id.card_reviews_count)
        private var name = itemView.findViewById<TextView>(R.id.card_film_name)
        private var duration = itemView.findViewById<TextView>(R.id.duration)

        fun bind(movie: Movie) {
            name.text = movie.name
            age.text = "${movie.age}+"
            like.setColorFilter(if (movie.isLiked) ContextCompat.getColor(itemView.context, R.color.like_liked) else ContextCompat.getColor(itemView.context, R.color.like_unliked))
            poster.setImageResource(movie.img)
            genre.text = movie.genre
            rating.rating = movie.rating
            reviewCount.text = "${movie.reviewsCount} reviews"
            duration.text = "${movie.duration} mins"
            like.setOnClickListener {
                movies[adapterPosition].isLiked = !movie.isLiked
                notifyItemChanged(adapterPosition)
            }
        }
    }
}
