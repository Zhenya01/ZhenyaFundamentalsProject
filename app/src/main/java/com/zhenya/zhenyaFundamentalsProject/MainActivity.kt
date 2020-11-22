package com.zhenya.zhenyaFundamentalsProject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        textView.setOnClickListener { goToMovies(this) }
    }

    fun goToMovies(context: Context){
        val nextIntent = Intent(context, MovieDetailsActivity::class.java)
        startActivity(nextIntent)
    }
}
