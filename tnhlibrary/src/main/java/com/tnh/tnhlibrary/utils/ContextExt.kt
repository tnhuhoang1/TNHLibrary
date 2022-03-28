package com.tnh.tnhlibrary.utils

import android.content.Context
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt

@ColorInt
fun Context.getColorFromAttr(@AttrRes res: Int): Int{
    val typedValue = TypedValue()
    theme.resolveAttribute(res, typedValue, true)
    return typedValue.data
}

fun Context.resolveAttr(@AttrRes res: Int): TypedValue {
    val typedValues = TypedValue()
    theme.resolveAttribute(res, typedValues, true)
    return typedValues
}
