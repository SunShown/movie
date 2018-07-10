package com.hui.movie

import android.app.Activity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import com.hui.movie.base.AndFixManagerJava
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : Activity() {
    var name:String? = "hellow"
    val APPTCH_PATH = "/out.apatch"
    var classLoadered:ClassLoader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_test.text = name
        initListener()
    }
    fun initListener(){
        show.setOnClickListener {
            Log.e("liufeixuan",name)
        }
        modify.setOnClickListener {
            val patchFileString = Environment.getExternalStorageDirectory()
                    .absolutePath + APPTCH_PATH
            AndFixManagerJava.getInstance(this).addPatch(patchFileString)
        }
    }
}
