package com.zhenya.zhenyaFundamentalsProject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ClickListener {
    private val moviesList = MoviesListFragment()
    private val movieDetails = MovieDetailsFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .apply {
                        add(R.id.fragments_container, moviesList)
                        commit()
                    }
        }
    }

    override fun backBtnPressed() {
        supportFragmentManager.popBackStack()
    }

    override fun movieCardPressed() {
        supportFragmentManager.beginTransaction()
                .apply {
                    add(R.id.fragments_container, movieDetails)
                    addToBackStack("movieDetails")
                    commit()
                }
    }
}
