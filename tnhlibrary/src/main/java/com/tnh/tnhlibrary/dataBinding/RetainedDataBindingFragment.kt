package com.tnh.tnhlibrary.dataBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open class RetainedDataBindingFragment<T: ViewDataBinding>(@LayoutRes var layoutRes: Int): Fragment() {
    internal var isRetained: Boolean = true
    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if(::binding.isInitialized.not() || !isRetained){
            binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        }
        doOnCreateView()
        return binding.root
    }

    open fun doOnCreateView(){

    }
}
