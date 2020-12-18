package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        if (activity !is ClickListenerInterface) {
            throw Exception("Activity doesn't implement ClickListener")
        }
        this.clickListener = activity as ClickListenerInterface
    }

    override fun onDetach() {
        super.onDetach()
        clickListener = null
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesList = mutableListOf(
                Movie("Avengers: End Game", R.drawable.avengers, false, 13, "Action, Adventure, Drama", 4f, 125, 137),
                Movie("Tenet", R.drawable.tenet, true, 16, "Action, Sci-Fi, Thriller", 5f, 98, 97),
                Movie("Black Widow", R.drawable.blackwidow, false, 13, "Action, Adventure, Sci-Fi", 4f, 38, 102),
                Movie("Wonder Woman 1984", R.drawable.wonderwoman, false, 13, "Action, Adventure, Fantasy", 5f, 74, 120)
        )

        val moviesRecycler = view.findViewById<RecyclerView>(R.id.movies_list)
        val adapter = MoviesListAdapter(context, moviesList, clickListener)
        moviesRecycler.adapter = adapter
        moviesRecycler.layoutManager = GridLayoutManager(this.context, 2)
        moviesRecycler.addItemDecoration(MoviesItemDecorator(resources))
    }
}