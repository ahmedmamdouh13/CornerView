package com.ahmedmamdouh13.cornertoview

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

fun Int.getColor(context: Context): Int {
    return ContextCompat.getColor(context, this)
}

fun Int.getDrawable(context: Context): Drawable {
    return ContextCompat.getDrawable(context, this)!!
}

fun Drawable.setCompatTint(color: Int) {
    DrawableCompat.setTint(this, color)
}

