package com.tnh.tnhlibrary.dataBinding.recycler

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.tnh.tnhlibrary.dataBinding.utils.inflateBinding
import com.tnh.tnhlibrary.utils.logE

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

        /**
         * create custom view holder extended from [DataBindingViewHolder]
         * */
        fun <T: ViewDataBinding> create(viewHolder: Class<out DataBindingViewHolder<T>>, container: ViewGroup, @LayoutRes layoutRes: Int): DataBindingViewHolder<T>{
            try {
                viewHolder.constructors.forEach {cons->
                    if(cons.parameterTypes.size == 1){
                        cons.parameterTypes.first().asSubclass(ViewDataBinding::class.java)
                        return viewHolder.getConstructor(cons.parameterTypes.first()).newInstance(container.inflateBinding(layoutRes))
                    }
                }
                throw Exception("Not extend from DataBindingViewHolder or constructor have more than one parameter")
            }catch (e: Exception){
                return from(container, layoutRes)
            }
        }

        /**
         * create custom view holder extended from [DataBindingViewHolder]
         * */
        fun <T: ViewDataBinding>safeCreate(
            viewHolder: Class<out DataBindingViewHolder<T>>,
            bindingClass: Class<out ViewDataBinding>,
            container: ViewGroup,
            @LayoutRes layoutRes: Int
        ): DataBindingViewHolder<T>{
            return try {
                viewHolder.getConstructor(bindingClass).newInstance(container.inflateBinding(layoutRes)) as DataBindingViewHolder<T>
            }catch (e: Exception){
                "Not extend from DataBindingViewHolder".logE()
                from(container, layoutRes)
            }
        }
    }
}