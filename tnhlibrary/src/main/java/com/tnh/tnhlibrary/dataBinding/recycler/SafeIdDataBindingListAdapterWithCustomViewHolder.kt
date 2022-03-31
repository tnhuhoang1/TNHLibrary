package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter

abstract class SafeIdDataBindingListAdapterWithCustomViewHolder<T: IdModel, B: ViewDataBinding>(
    @LayoutRes val itemLayout: Int,
    private val viewHolderType: Class<out DataBindingViewHolder<B>>,
    private val bindingClass: Class<out ViewDataBinding>
): ListAdapter<T, DataBindingViewHolder<B>>(IdDataCallbackItem<T>()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DataBindingViewHolder<B> {
        val holder = DataBindingViewHolder.safeCreate(viewHolderType, bindingClass, parent, itemLayout)
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
