package com.rjasso.movieapp

import com.rjasso.movieapp.model.MoviesResponse
import retrofit2.Call

class Repository {
    fun loadPagesFromAPI(): Call<MoviesResponse> {
        val map: HashMap<String,String> = HashMap()
        map.put("api_key","0783e62dda7c99eb3db8ac34d03bc435")
        map.put("language","en-US")
        map.put("page","1")
        return RetrofitClient.instance.getNowPlayingMoviesList(map)
    }
}
