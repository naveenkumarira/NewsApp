package com.example.newsapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.newsapp.activity.ArticleDetailActivity
import com.example.newsapp.model.Movie
import com.example.newsapp.repository.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        GlobalScope.launch(Dispatchers.Main) {
            val movieResponse = async(Dispatchers.IO) { HomeRepository().getMovieRepository() }
            val memeResponse = async(Dispatchers.IO) { HomeRepository().getMemeData() }
            findViewById<TextView>(R.id.text).text = movieResponse.await() + memeResponse.await()
        }

        val movie = Movie(1,"Title", 2019)
        val movie1 = Movie(1,"Title", 2019)
        if(movie == movie1) {
            Log.d("MOVIE: ", "SAME ==")
        }

        if(movie === movie1) {
            Log.d("MOVIE: ", "SAME ==")
        } else {
            Log.d("MOVIE: ", "Different  Address spaces ===")
        }

        findViewById<Button>(R.id.button).setOnClickListener {+
            val intent = Intent(this@HomeActivity, ArticleDetailActivity::class.java)
            startActivity(intent)
        }
    }
}
