package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MovieDetailsFragment : Fragment() {

    private var clickListenerInterface: ClickListenerInterface? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_details, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity !is ClickListenerInterface) {
            throw Exception("Activity doesn't implement ClickListener")
        }
        this.clickListenerInterface = activity as ClickListenerInterface
    }

    override fun onDetach() {
        super.onDetach()
        clickListenerInterface = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val backButton = view.findViewById<TextView>(R.id.back)
        backButton.setOnClickListener {
            clickListenerInterface?.backBtnPressed()
        }

        val actorsList = listOf(
                Actor("Robert Downey Jr.", R.drawable.downey_jr),
                Actor("Cris Evans", R.drawable.evans),
                Actor("Mark Ruffalo", R.drawable.ruffalo),
                Actor("Chris Hemsworth", R.drawable.hemsworth)
        )


        val actorsRecycler = view.findViewById<RecyclerView>(R.id.actors_recycler)
        val adapter = ActorsListAdapter(context, actorsList)
        actorsRecycler.adapter = adapter
        actorsRecycler.layoutManager = object : LinearLayoutManager(context, RecyclerView.HORIZONTAL, false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams): Boolean {
                // force height of viewHolder here, this will override layout_height from xml
                lp.width = (width / 4) - 3 * 8
                return true
            }
        }
        actorsRecycler.addItemDecoration(ActorsItemDecorator(resources, actorsList.size))
    }
}