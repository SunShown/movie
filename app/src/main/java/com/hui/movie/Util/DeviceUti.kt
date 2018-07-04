package com.hui.movie.Util

import android.content.Context
import android.content.pm.PackageManager

fun getVersionNumber(context: Context):String{
    val packageManager = context.packageManager
    val pi = packageManager.getPackageInfo(context.packageName,0)
    val version = pi.versionName
    return version
}