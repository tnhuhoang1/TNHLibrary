package com.tnh.tnhlibrary.dataBinding.recycler

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

abstract class IdDataBindingListAdapter<M: IdModel, B: ViewDataBinding>(@LayoutRes layoutRes: Int): DataBindingListAdapter<M, B>(layoutRes, IdDataCallbackItem())