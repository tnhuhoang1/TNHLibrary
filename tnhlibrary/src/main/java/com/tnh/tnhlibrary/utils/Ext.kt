package com.tnh.tnhlibrary.utils

import android.content.ContentResolver
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

val Int.pxToDp
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

val Int.dpToPx
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun getResourceUri(context: Context, id: Int): Uri {
    return Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(context.resources.getResourcePackageName(id))
        .appendPath(context.resources.getResourceTypeName(id))
        .appendPath(context.resources.getResourceEntryName(id))
        .build()
}

fun Fragment.checkSelfPermission(permission: String): Boolean{
    return ContextCompat.checkSelfPermission(requireContext(), permission) == PackageManager.PERMISSION_GRANTED
}