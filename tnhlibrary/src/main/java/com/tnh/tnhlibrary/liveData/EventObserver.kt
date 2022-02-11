package com.tnh.tnhlibrary.liveData

import androidx.lifecycle.Observer

class EventObserver<T>(
    private val doBeforeHandled: (T) -> Unit
): Observer<EventLiveData<T>> {
    override fun onChanged(t: EventLiveData<T>?) {
        t?.getContentOnce()?.let(doBeforeHandled)
    }
}