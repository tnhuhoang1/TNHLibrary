package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter

/**
 * simple list adapter with custom view holder (must extend from [DataBindingViewHolder])
 * */
abstract class IdDataBindingListAdapterWithCustomViewHolder<T: IdModel, B: ViewDataBinding>(
    private val viewHolderType: Class<out DataBindingViewHolder<B>>, @LayoutRes val layoutRes: Int,
): ListAdapter<T, DataBindingViewHolder<B>>(IdDataCallbackItem<T>()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<B> {
        val holder = DataBindingViewHolder.create(viewHolderType, parent, layoutRes)
        initStateViewHolder(holder)
        return holder
    }

    /**
     * Function is called before return from onCreateViewHolder method
     *
     * @param holder: The view holder created by onCreateViewHolder
     */
    open fun initStateViewHolder(holder: DataBindingViewHolder<B>){}
}
