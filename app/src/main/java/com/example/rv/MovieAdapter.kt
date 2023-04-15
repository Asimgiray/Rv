package com.example.rv

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rv.databinding.ItemMovieBinding

class MovieAdapter (private var movieList: ArrayList<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    class ViewHolder(val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ItemMovieBinding = DataBindingUtil.inflate(inflater, R.layout.item_movie, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movieList[position]

        Log.d("MovieName", currentMovie.name)

        holder.binding.txtName.text = currentMovie.name
        holder.binding.txtYear.text = currentMovie.year.toString()
        holder.binding.imgPoster.loadUrl(currentMovie.image)
        //Glide.with(holder.binding.root).load(currentMovie.image).into(holder.binding.imgPoster)

    }

    override fun getItemCount(): Int = movieList.size


}