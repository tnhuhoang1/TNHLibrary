package com.tnh.tnhlibrary.dataBinding.recycler


open class DefaultCallbackItem<MODEL>: BaseCallbackItem<MODEL>() {
    override fun areContentsTheSame(oldItem: MODEL, newItem: MODEL) = oldItem.toString() == newItem.toString()
}