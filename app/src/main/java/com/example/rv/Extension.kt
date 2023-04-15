package com.example.rv

import android.widget.ImageView
import com.bumptech.glide.Glide

fun String.isGiray() : Boolean {
    return this.equals("giray", false)
}

fun ImageView.loadUrl(url: String) {
    Glide.with(this.rootView).load(url).into(this)
}