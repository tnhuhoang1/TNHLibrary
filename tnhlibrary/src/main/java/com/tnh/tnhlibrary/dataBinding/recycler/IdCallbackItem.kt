package com.tnh.tnhlibrary.dataBinding.recycler

/**
 * Simple callback for item that has unique id
 * */
class IdCallbackItem<MODEL: IdModel>: BaseCallbackItem<MODEL>() {
    override fun areItemsTheSame(oldItem: MODEL, newItem: MODEL): Boolean {
        return oldItem.identification == newItem.identification
    }

    override fun areContentsTheSame(oldItem: MODEL, newItem: MODEL): Boolean {
        return oldItem.toString() == newItem.toString()
    }
}