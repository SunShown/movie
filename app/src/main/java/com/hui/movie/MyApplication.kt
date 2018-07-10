package com.hui.movie

import android.app.Application
import android.os.Environment
import android.util.Log
import com.hui.movie.base.AndFixManagerJava

class MyApplication :Application(){

    override fun onCreate() {
        super.onCreate()
        Log.e("liufeixuan","oncreate")
        AndFixManagerJava.getInstance(this).initPatchManager()

    }
}