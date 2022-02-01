package com.tnh.tnhlibrary

import android.os.Build

class VersionUtils{
    companion object{
        val SDK_INT = Build.VERSION.SDK_INT
    }
}

inline fun checkVersionIf(
    condition: Boolean = true,
    ifTrue: () -> Unit,
    ifFalse: ()-> Unit
){
    if(condition){
        ifTrue()
    }else{
        ifFalse()
    }
}

inline fun checkVersionIfTrue(
    condition: Boolean = true,
    ifTrue: () -> Unit
){
    checkVersionIf(condition, ifTrue) {}
}

inline fun checkVersionIfFalse(
    condition: Boolean = false,
    ifFalse: () -> Unit
){
    checkVersionIf(condition, {}, ifFalse)
}

inline fun Int.versionET(
    blockTrue: () -> Unit,
    blockFalse: () -> Unit
){
    checkVersionIf(
        Build.VERSION.SDK_INT == this,
        blockTrue,
        blockFalse
    )
}

inline fun Int.versionGTOET(
    blockTrue: () -> Unit,
    blockFalse: () -> Unit
){
    checkVersionIf(
        Build.VERSION.SDK_INT > this,
        blockTrue,
        blockFalse
    )
}

inline fun Int.versionLTOET(
    blockTrue: () -> Unit,
    blockFalse: () -> Unit
){
    checkVersionIf(
        Build.VERSION.SDK_INT < this,
        blockTrue,
        blockFalse
    )
}

inline fun Int.versionGT(
    blockTrue: () -> Unit,
    blockFalse: () -> Unit
){
    (this + 1).versionGTOET(
        blockTrue,
        blockFalse
    )
}

inline fun Int.versionLT(
    blockTrue: () -> Unit,
    blockFalse: () -> Unit
){
    (this - 1).versionLTOET(
        blockTrue,
        blockFalse
    )
}

inline fun Int.ifVersionET(
    block: () -> Unit
){
    this.versionET(block) {}
}

inline fun Int.ifVersionGTOET(
    block: () -> Unit
){
    this.versionGTOET(block) {}
}

inline fun Int.ifVersionLTOET(
    block: () -> Unit
){
    this.versionLTOET(block) {}
}

inline fun Int.ifVersionGT(
    block: () -> Unit
){
    this.versionGT(block) {}
}

inline fun Int.ifVersionLT(
    block: () -> Unit
){
    this.versionLT(block) {}
}



