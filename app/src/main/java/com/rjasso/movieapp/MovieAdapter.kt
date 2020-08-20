package com.rjasso.movieapp

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.movie_item.view.*
import com.rjasso.movieapp.model.Result
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener

import com.bumptech.glide.request.target.Target


class MovieAdapter(val movies: ArrayList<Result>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.textView.text = movies[position].original_title
        Glide.with(holder.itemView.context)
            .load(Constants.IMGURL + movies[position].poster_path + Constants.API_KEY)
            .centerCrop()
            .into(holder.itemView.imageView)

        holder.itemView.setOnClickListener({
            Log.d("Log!!",movies[position].title)
        })
    }

}
