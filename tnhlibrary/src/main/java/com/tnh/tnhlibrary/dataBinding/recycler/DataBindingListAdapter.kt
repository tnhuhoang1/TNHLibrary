package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class DataBindingListAdapter<MODEL, DATA_BINDING_CLASS: ViewDataBinding>(
    @LayoutRes val itemLayout: Int, itemCallback: DiffUtil.ItemCallback<MODEL>
): ListAdapter<MODEL, DataBindingViewHolder<DATA_BINDING_CLASS>>(itemCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<DATA_BINDING_CLASS> {
        return DataBindingViewHolder.from(parent, itemLayout)
    }
}