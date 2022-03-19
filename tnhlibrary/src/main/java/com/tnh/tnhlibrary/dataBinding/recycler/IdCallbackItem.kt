package com.tnh.tnhlibrary.dataBinding.recycler

class IdCallbackItem: BaseCallbackItem<IdModel>() {
    override fun areItemsTheSame(oldItem: IdModel, newItem: IdModel): Boolean {
        return oldItem.identification == newItem.identification
    }

    override fun areContentsTheSame(oldItem: IdModel, newItem: IdModel): Boolean {
        return oldItem.toString() == newItem.toString()
    }
}