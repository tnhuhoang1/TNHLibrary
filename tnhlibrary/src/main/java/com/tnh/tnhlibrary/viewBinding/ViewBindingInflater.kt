package com.tnh.tnhlibrary.viewBinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

interface ViewBindingInflater<T: ViewBinding> {
    fun onInflate(inflater: LayoutInflater, container: ViewGroup?, attach: Boolean = false): T
}