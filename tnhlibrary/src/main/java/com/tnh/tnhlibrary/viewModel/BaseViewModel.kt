package com.tnh.tnhlibrary.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tnh.tnhlibrary.liveData.EventLiveData
import com.tnh.tnhlibrary.liveData.utils.toLiveData

open class BaseViewModel: ViewModel() {
    private val _message = MutableLiveData<EventLiveData<String>>()
    val message = _message.toLiveData()

    fun setMessage(message: String){
        _message.value = EventLiveData(message)
    }

    fun postMessage(message: String){
        _message.postValue(EventLiveData(message))
    }

    private val _clickEvent = MutableLiveData<EventLiveData<String>>()
    val clickEvent = _clickEvent.toLiveData()

    fun dispatchClickEvent(eventName: String){
        _clickEvent.postValue(EventLiveData(eventName))
    }
}
