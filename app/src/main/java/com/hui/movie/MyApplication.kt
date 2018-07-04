package com.hui.movie

import android.app.Application
import android.os.Environment
import android.util.Log
import com.hui.movie.base.AndFixManagerJava

class MyApplication :Application(){
    val APPTCH_PATH = "/out.apatch"
    override fun onCreate() {
        super.onCreate()
        Log.e("liufeixuan","oncreate")
        AndFixManagerJava.getInstance(this).initPatchManager()
        val patchFileString = Environment.getExternalStorageDirectory()
                .absolutePath + APPTCH_PATH
        AndFixManagerJava.getInstance(this).addPatch(patchFileString)
    }
}