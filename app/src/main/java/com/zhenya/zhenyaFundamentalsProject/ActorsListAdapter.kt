package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorsListAdapter(var context: Context?, var actors: List<Actor>) : RecyclerView.Adapter<ActorsListAdapter.ActorsListViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorsListViewHolder {

        return ActorsListViewHolder(inflater.inflate(R.layout.view_holder_actor_card, parent, false))
    }

    override fun onBindViewHolder(holder: ActorsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount(): Int = actors.size

    private fun getItem(position: Int): Actor = actors[position]

    inner class ActorsListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var name = view.findViewById<TextView>(R.id.actor_name)
        private var photo = view.findViewById<ImageView>(R.id.actor_img)

        fun bind(actor: Actor) {
            name.text = actor.name
            photo.setImageResource(actor.photo)
        }

    }
}