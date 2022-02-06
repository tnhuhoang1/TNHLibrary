package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tnh.tnhlibrary.dataBinding.utils.inflateBinding

abstract class AbstractDataBindingViewHolder<T: ViewDataBinding>(
        @LayoutRes layoutRes: Int,
        parent: ViewGroup,
        val binding: T = parent.inflateBinding<T>(layoutRes)
): RecyclerView.ViewHolder(binding.root){
}

