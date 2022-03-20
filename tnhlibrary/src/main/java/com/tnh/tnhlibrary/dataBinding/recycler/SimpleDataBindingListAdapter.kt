package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class SimpleDataBindingListAdapter<MODEL, DATA_BINDING_CLASS: ViewDataBinding>(@LayoutRes itemLayout: Int): DataBindingListAdapter<MODEL, DATA_BINDING_CLASS>(itemLayout, DefaultCallbackItem())