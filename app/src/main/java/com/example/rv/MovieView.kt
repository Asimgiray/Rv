package com.example.rv

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import com.example.rv.databinding.ItemMovieBinding

class MovieView  @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0
) : CardView(context, attributeSet, defStyle) {

    lateinit var binding: ItemMovieBinding

    init {
        initBinding()
    }

    private fun initBinding() {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_movie,
            this,
            true
        )
    }

    fun bindData(movie: Movie) {
        binding.txtYear.text = movie.year.toString()
        binding.txtName.text = movie.name
        binding.imgPoster.loadUrl(movie.image)
    }


}