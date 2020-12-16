package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


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
    }


}