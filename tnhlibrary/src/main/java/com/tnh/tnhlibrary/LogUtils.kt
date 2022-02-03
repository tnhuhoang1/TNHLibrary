package com.tnh.tnhlibrary

import android.app.Activity
import android.util.Log
import androidx.fragment.app.Fragment

infix fun String.log(message: String){
    "$this $message".logI()
}

infix fun String.debug(message: String?){
    "$this $message".logE()
}

fun Any?.logAny(tag: String = "Test"){
    ">> ${this.toString()}".logI(tag)
}

fun Any?.logVar(name: String, tag: String = "Test"){
    "$name: ${this.toString()}".logI(tag)
}

fun String?.logI(tag: String = "Test"){
    Log.i(tag, this.toString())
}

fun String?.logE(tag: String = "Test"){
    Log.e(tag, this.toString())
}

fun String?.logW(tag: String = "Test"){
    Log.w(tag, this.toString())
}

fun Fragment.log(message: String?){
    "${this::class.simpleName}# $message".logI()
}

fun Activity.log(message: String){
    "${this::class.simpleName}# $message".logI()
}

fun Any.trace(e: Exception?){
    "${this::class.simpleName}! ${e?.stackTraceToString()}".logE()
}

fun Any.simpleLog(message: String?){
    "${this::class.simpleName}$ $message".logI()
}

fun Activity.debug(message: String){
    "${this::class.simpleName}@ $message".logW()
}

fun Fragment.debug(message: String){
    "${this::class.simpleName}@ $message".logW()
}
