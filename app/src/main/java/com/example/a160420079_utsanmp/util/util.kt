package com.example.a160420079_utsanmp.util

import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.net.URL

fun ImageView.loadImage(url: String?){
    Picasso.get()
        .load(url)
        .resize(400, 400)
        .centerCrop()
        .into(this)
}