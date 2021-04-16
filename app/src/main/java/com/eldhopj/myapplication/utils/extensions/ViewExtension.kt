package com.eldhopj.myapplication.utils.extensions

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.appcompat.widget.AppCompatImageButton
import androidx.core.widget.ImageViewCompat
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

/**
 * Get EditText value
 */
val EditText.value
    get() = text?.toString() ?: ""

/**
 * Set tint to Image Button
 *
 * @param color
 */
fun AppCompatImageButton.setTint(@ColorInt color: Int?) {
    if (color == null) {
        ImageViewCompat.setImageTintList(this, null)
        return
    }
    ImageViewCompat.setImageTintMode(this, PorterDuff.Mode.SRC_ATOP)
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color))
}
