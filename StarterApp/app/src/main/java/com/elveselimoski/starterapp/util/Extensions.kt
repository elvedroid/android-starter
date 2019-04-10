package com.elveselimoski.starterapp.util

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(image: Any) {
    Glide.with(context).load(image).into(this)
}


