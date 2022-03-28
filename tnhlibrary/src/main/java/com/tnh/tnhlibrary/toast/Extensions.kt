package com.tnh.tnhlibrary.toast

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tnh.tnhlibrary.utils.trace

/**
 * show toast
 *
 * @param content[String]: The content you want to show
 * @param length[Int]: Duration of toast
 */
fun Context.showToast(content: String, length: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, content, length).show()
}

/**
 * quicker method to show toast in fragment
 */
fun Fragment.showToast(content: String, length: Int = Toast.LENGTH_SHORT){
    try {
        requireContext().showToast(content, length)
    }catch (e: IllegalStateException){
        trace(e)
    }
}

/**
 * convert any type and show it as toast
 */
fun Any?.toToast(context: Context, length: Int = Toast.LENGTH_SHORT){
    context.showToast(this.toString(), length)
}