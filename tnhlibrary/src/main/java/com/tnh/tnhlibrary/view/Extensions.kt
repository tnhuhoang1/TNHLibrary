package com.tnh.tnhlibrary.view

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.tnh.tnhlibrary.utils.trace

fun View.gone(){
    this.visibility = View.GONE
}

inline fun View.doAndGone(block: View.() -> Unit){
    block()
    gone()
}

fun View.show(){
    this.visibility = View.VISIBLE
}

inline fun View.doAndShow(block: View.() -> Unit){
    block()
    show()
}

/**
 * set visibility of this view to INVISIBLE
 */
fun View.hide(){
    this.visibility = View.INVISIBLE
}

inline fun View.doAndHide(block: View.() -> Unit){
    block()
    hide()
}


/**
 * execute the block if the view visibility is not set to VISIBLE
 */
inline fun View.ifVisible(
    block: View.() -> Unit
){
    if(this.visibility != View.VISIBLE){
        block()
    }
}

/**
 * execute the block if the view visibility is not set to GONE
 */
inline fun View.ifGone(
    block: View.() -> Unit
){
    if(this.visibility != View.GONE){
        block()
    }
}


fun View.hideKeyboard(){
    try {
        (context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager)
        .hideSoftInputFromWindow(windowToken, 0)
    }catch (e: Exception){
        trace(e)
    }
}
