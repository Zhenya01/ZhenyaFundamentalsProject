package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView

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

    override fun backBtnPressed(){
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

    /*fun goToMovies(context: Context){
        val nextIntent = Intent(context, MovieDetailsActivity::class.java)
        startActivity(nextIntent)
    }*/
}
