package com.tnh.tnhlibrary.liveData.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tnh.tnhlibrary.liveData.EventLiveData
import com.tnh.tnhlibrary.liveData.EventObserver

/**
 * return immutable live data with the same type
 */
fun <T: Any?> MutableLiveData<T>.toLiveData(): LiveData<T> {
    return this
}

/**
 * observe data only if the data is not null
 */
fun <T> Fragment.safeObserve(
    data: LiveData<T>,
    owner: LifecycleOwner = viewLifecycleOwner,
    observer: (T) -> Unit
){
    data.observe(owner){
        it?.let(observer)
    }
}

/**
 * quicker method to object event live data in fragment
 */
fun <T> Fragment.eventObserve(
    data: LiveData<EventLiveData<T>>,
    owner: LifecycleOwner = viewLifecycleOwner,
    observer: (T) -> Unit
){
    data.observe(owner, EventObserver(observer))
}