package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.recyclerview.widget.DiffUtil

/**
 * this is not recommended way to check item
 * */
abstract class BaseCallbackItem<MODEL>: DiffUtil.ItemCallback<MODEL>(){
    override fun areItemsTheSame(oldItem: MODEL, newItem: MODEL) = oldItem === newItem
}