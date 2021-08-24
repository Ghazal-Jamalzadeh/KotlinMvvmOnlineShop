package com.jmzd.ghazal.kotlinmvvmonlineshop.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object GlideImage {
    @JvmStatic // چون این قسمت باید استاتیک باشد
    @BindingAdapter("image")
    fun Getimage(view: ImageView, url:String){
        Glide.with(view).load(url).into(view)
    }
}