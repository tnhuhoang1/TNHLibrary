package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tnh.tnhlibrary.dataBinding.utils.inflateBinding

open class DataBindingViewHolder<DATA_BINDING_CLASS: ViewDataBinding> private constructor(
    val binding: DATA_BINDING_CLASS
): RecyclerView.ViewHolder(binding.root) {
    fun bind(block: (binding: DATA_BINDING_CLASS) -> Unit){
        block(binding)
    }
    companion object{
        fun <T: ViewDataBinding> from(container: ViewGroup, @LayoutRes layoutRes: Int): DataBindingViewHolder<T>{
            return DataBindingViewHolder(container.inflateBinding(layoutRes))
        }
    }
}