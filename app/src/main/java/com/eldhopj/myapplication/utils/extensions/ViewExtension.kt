package com.eldhopj.myapplication.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.eldhopj.myapplication.R

/**
 * Glide
 *
 * @param url
 */
// TODO : update placeholder and error images
fun ImageView.glide(url: String?) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.ic_launcher_foreground)
        .centerCrop()
        .fallback(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}
