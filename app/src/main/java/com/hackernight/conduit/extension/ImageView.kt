package com.hackernight.conduit.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(uri:String,isCircle:Boolean=false){
    if (isCircle){
        Glide.with(this).load(uri).circleCrop().into(this)
    }else{
        Glide.with(this).load(uri).into(this)
    }
}