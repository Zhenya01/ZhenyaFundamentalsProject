package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.cardview.widget.CardView



private var movie: CardView? = null



class MoviesListFragment : Fragment() {

    private var clickListener: ClickListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is ClickListener) {
            this.clickListener = activity as ClickListener
        }
    }
    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val movie = view.findViewById<CardView>(R.id.movieCard)
        movie.setOnClickListener { clickListener?.movieCardPressed() }

    }

}