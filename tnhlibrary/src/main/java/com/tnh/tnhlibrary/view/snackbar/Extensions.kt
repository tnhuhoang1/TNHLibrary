package com.tnh.tnhlibrary.view.snackbar

import android.app.Activity
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.tnh.tnhlibrary.utils.trace

fun Activity.showSnackbar(
    message: String, length: Int = Snackbar.LENGTH_SHORT
){
    try {
        Snackbar.make(findViewById(android.R.id.content), message, length).show()
    }catch (e: Exception){
        trace(e)
    }
}

fun View.showSnackBar(message: String, length: Int = Snackbar.LENGTH_SHORT){
    Snackbar.make(this, message, length).show()
}

fun View.buildSnackBar(
    message: String,
    length: Int = Snackbar.LENGTH_SHORT,
    builder: (Snackbar)-> Unit = {}
){
    Snackbar.make(this, message, length).apply(builder).show()
}