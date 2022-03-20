package com.tnh.tnhlibrary.dataBinding.recycler

import android.annotation.SuppressLint

class IdDataCallbackItem<M: IdModel>: IdCallbackItem<M>(){
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: M, newItem: M): Boolean {
        return if(oldItem::class.isData){
            oldItem == newItem
        }else{
            super.areContentsTheSame(oldItem, newItem)
        }
    }
}