package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.recyclerview.widget.DiffUtil

abstract class BaseCallbackItem<MODEL>: DiffUtil.ItemCallback<MODEL>(){
    override fun areItemsTheSame(oldItem: MODEL, newItem: MODEL) = oldItem === newItem
}