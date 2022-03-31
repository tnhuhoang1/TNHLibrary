package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class DataBindingListAdapter<MODEL, DATA_BINDING_CLASS: ViewDataBinding>(
    @LayoutRes val itemLayout: Int, itemCallback: DiffUtil.ItemCallback<MODEL>
): ListAdapter<MODEL, DataBindingViewHolder<DATA_BINDING_CLASS>>(itemCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<DATA_BINDING_CLASS> {
        val holder = DataBindingViewHolder.from<DATA_BINDING_CLASS>(parent, itemLayout)
        initStateViewHolder(holder)
        return holder
    }

    /**
     * Function is called before return from onCreateViewHolder method
     *
     * @param holder: The view holder created by onCreateViewHolder
     */
    open fun initStateViewHolder(holder: DataBindingViewHolder<DATA_BINDING_CLASS>){}
}