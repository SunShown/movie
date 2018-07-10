package com.hui.movie

import android.app.Activity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.hui.movie.base.AndFixManagerJava
import com.hui.movie.tinker.TinkerManager
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : Activity() {
    val FILE_END=".apk"
    lateinit var mPatchDir:String
    var classLoadered:ClassLoader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPatchDir = externalCacheDir.absolutePath +"/tpacth/";
        val file:File = File(mPatchDir)
        if (file == null || !file.exists()){
            file.mkdir()
        }

        modify.setOnClickListener {
            Log.e("liufeixuan",getPatchName())
            TinkerManager.loadPatch(getPatchName())
        }
    }
    fun getPatchName():String{
        return mPatchDir + "movie$FILE_END"
    }
}
