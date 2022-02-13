package com.tnh.tnhlibrary.preference

import android.content.Context
import android.content.SharedPreferences

open class PrefManager private constructor(
    private val appContext: Context
) {
    private var pref = appContext.getSharedPreferences(appContext.packageName + "_preferences", Context.MODE_PRIVATE)
    private var editor = pref.edit()
    fun changePref(pref: SharedPreferences){
        this.pref = pref
        editor = pref.edit()
    }

    fun changePref(name: String, mode: Int){
        changePref(appContext.getSharedPreferences(name, mode))
    }

    fun getString(key: String, default: String = DEFAULT_STRING) = pref.getString(key, default) ?: default

    fun getInt(key: String, default: Int = DEFAULT_INT) = pref.getInt(key, default)

    fun getLong(key: String, default: Long = DEFAULT_LONG) = pref.getLong(key, default)

    fun getFloat(key: String, default: Float = DEFAULT_FLOAT) = pref.getFloat(key, default)

    fun putString(key: String, value: String){
        editTransaction {
            putString(key, value)
        }
    }

    fun putFloat(key: String, value: Float){
        editTransaction {
            putFloat(key, value)
        }
    }

    fun putInt(key: String, value: Int){
        editTransaction {
            putInt(key, value)
        }
    }

    fun putLong(key: String, value: Long){
        editTransaction {
            putLong(key, value)
        }
    }

    private inline fun editTransaction(block: SharedPreferences.Editor.() -> SharedPreferences.Editor){
        block(editor).apply()
    }

    companion object{
        @Volatile
        private lateinit var instance: PrefManager

        fun getInstance(appContext: Context): PrefManager{
            if(::instance.isInitialized.not()){
                instance = PrefManager(appContext)
            }
            return instance
        }

        const val DEFAULT_STRING = ""
        const val DEFAULT_INT = 0
        const val DEFAULT_FLOAT = 0f
        const val DEFAULT_LONG = 0L
    }
}