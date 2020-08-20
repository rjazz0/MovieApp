package com.rjasso.movieapp

import com.rjasso.movieapp.model.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MovieAPI {
    @GET("now_playing")
    fun getNowPlayingMoviesList(@QueryMap map: HashMap<String,String>): Call<MoviesResponse>
}