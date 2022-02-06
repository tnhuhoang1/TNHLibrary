package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleDataBindingListAdapter<MODEL, DATA_BINDING_CLASS: ViewDataBinding>(
    @LayoutRes itemLayout: Int
): DataBindingListAdapter<MODEL, DATA_BINDING_CLASS>(itemLayout, DefaultCallbackItem()) {
}