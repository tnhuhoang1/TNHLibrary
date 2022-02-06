package com.tnh.tnhlibrary.dataBinding.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.tnh.tnhlibrary.dataBinding.DataBindingFragment

fun <T: ViewDataBinding> Fragment.initBinding(@LayoutRes layoutId: Int, parent: ViewGroup?, attach: Boolean = false): T{
    return DataBindingUtil.inflate(layoutInflater, layoutId, parent, attach)
}

fun <T: ViewDataBinding> ViewGroup.inflateBinding(@LayoutRes layoutId: Int, attach: Boolean = false): T{
    return DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, attach)
}

fun <T: ViewDataBinding> DataBindingFragment<T>.initBinding(container: ViewGroup?, @LayoutRes layoutId: Int = this.layoutRes, attach: Boolean = false): T{
    return DataBindingUtil.inflate(layoutInflater, layoutId, container, attach)
}
