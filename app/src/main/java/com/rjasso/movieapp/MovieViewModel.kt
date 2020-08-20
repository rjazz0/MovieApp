package com.rjasso.movieapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rjasso.movieapp.model.MoviesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    private val repository = Repository()
    private val results: MutableLiveData<MoviesResponse> by lazy {
        MutableLiveData<MoviesResponse> ().also {
            loadMovies()
        }
    }

    fun getMovies(): LiveData<MoviesResponse> {
        return results
    }

    private fun loadMovies() {
        repository.loadPagesFromAPI().enqueue(object: Callback<MoviesResponse> {
            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                t?.let { Log.d(MoviesResponse::class.java.canonicalName, it?.message) }
            }

            override fun onResponse(call: Call<MoviesResponse>?, response: Response<MoviesResponse>?) {
                response?.body()?.let { results.value = it }
            }
        })
    }
}