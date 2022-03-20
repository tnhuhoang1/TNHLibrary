package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class IdClickableDataBindingListAdapter<M: IdModel, DATA_BINDING_CLASS: ViewDataBinding>(
    @LayoutRes itemLayout: Int
): IdDataBindingListAdapter<M, DATA_BINDING_CLASS>(itemLayout){
    private var rootClickListener: DataBindingItemClickListener<M, DATA_BINDING_CLASS> = DataBindingItemClickListener { _, _, _ -> }

    override fun onBindViewHolder(holder: DataBindingViewHolder<DATA_BINDING_CLASS>, position: Int) {
        val data = getItem(position)
        holder.binding.root.setOnClickListener {
            rootClickListener.onItemClicked(data, holder.binding, position)
        }
        bindViewHolder(holder, data, position)
    }
    abstract fun bindViewHolder(holder: DataBindingViewHolder<DATA_BINDING_CLASS>,itemData: M, position: Int)

    fun setRootClickListener(listener: DataBindingItemClickListener<M, DATA_BINDING_CLASS>){
        rootClickListener = listener
    }
}

