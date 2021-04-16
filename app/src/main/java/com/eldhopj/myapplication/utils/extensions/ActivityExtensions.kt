package com.eldhopj.myapplication.utils.extensions

import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * Blocks input from user
 *
 * */
fun AppCompatActivity.blockInput() {
    window.setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
}

/**
 * Un Blocks input from user
 *
 * */
fun AppCompatActivity.unblockInput() {
    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}
