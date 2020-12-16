package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment


private var movie: CardView? = null



class MoviesListFragment : Fragment() {

    private var clickListener: ClickListenerInterface? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is ClickListenerInterface) {
            this.clickListener = activity as ClickListenerInterface
        }
    }
    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = view.findViewById<CardView>(R.id.movieCard)
        val like = movie.findViewById<ImageView>(R.id.like)
        /*like.drawable.setTint(Color.parseColor("#FF0000"))*/
        movie.setOnClickListener { clickListener?.movieCardPressed() }

    }

}