package com.tnh.tnhlibrary.viewBinding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class ViewBindingFragment<VIEW_BINDING_CLASS: ViewBinding>: Fragment(), ViewBindingInflater<VIEW_BINDING_CLASS> {
    lateinit var binding: VIEW_BINDING_CLASS
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = onInflate(inflater, container)
        doOnCreateView()
        return binding.root
    }

    open fun doOnCreateView(){

    }
}