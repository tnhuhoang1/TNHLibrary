package com.tnh.tnhlibrary.dataBinding.recycler

fun interface DataBindingItemClickListener<MODEL, DATA_BINDING_CLASS> {
    fun onItemClicked(data: MODEL, binding: DATA_BINDING_CLASS, position: Int)
}