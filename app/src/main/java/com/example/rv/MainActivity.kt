package com.example.rv

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context

    val movie1 = Movie(
        image = "https://tr.web.img4.acsta.net/c_310_420/pictures/bzp/01/29276.jpg",
        name = "Harry Potter",
        year = 2005
    )

    val movie2 = Movie(
        image = "https://tr.web.img4.acsta.net/pictures/bzp/01/27070.jpg",
        name = "Lord of the Rings",
        year = 2003
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        init()
        listeners()
    }

    private fun init() {
        val movieAdapter = MovieAdapter(arrayListOf(movie1, movie2))
        binding.rvMovies.adapter = movieAdapter
        binding.rvMovies.layoutManager = LinearLayoutManager(this)
        binding.myMovie.bindData(movie1)
    }

    private fun listeners() {

        binding.btnAddMovie.setOnClickListener {
            val movieView = MovieView(context = context)
            movieView.bindData(movie2)
            binding.linMain.addView(movieView)

        }
    }
}