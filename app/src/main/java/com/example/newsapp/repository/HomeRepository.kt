package com.example.newsapp.repository

import okhttp3.OkHttpClient
import okhttp3.Request


class HomeRepository {

    companion object {
        const val MOVIE_API: String = "https://facebook.github.io/react-native/movies.json"
        const val MEME_API: String = "https://api.imgflip.com/get_memes"

    }
    fun getMemeData(): String {

        val client = OkHttpClient()

        val request = Request.Builder()
            .url(MEME_API)
            .build()

        val response = client.newCall(request).execute()

        return if(response.isSuccessful) {
            response.body?.string() ?:""
        } else {
            "Movie API Error"
        }

    }

    fun getMovieRepository(): String {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url(MOVIE_API)
            .build()

        val response = client.newCall(request).execute()

        return if(response.isSuccessful) {
            response.body?.string() ?:""
        } else {
            "Movie API Error"
        }
    }
}