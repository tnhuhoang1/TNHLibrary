package com.tnh.tnhlibrary.liveData

class EventLiveData<out TYPE: Any?>(
    private val content: TYPE? = null
) {
    private var isHandled = false

    fun getContentOnce(): TYPE?{
        return if(isHandled){
            null
        }else{
            isHandled = true
            content
        }
    }

    fun getContent() = content
}