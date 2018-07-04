package com.hui.movie

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import dalvik.system.DexClassLoader
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File
import java.lang.reflect.Method
import java.util.logging.Logger

class MainActivity : Activity() {
    var classLoadered:ClassLoader? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initListener()
        while (classLoadered != null){
            Log.e("liufeixuan",classLoadered.toString())
            classLoadered = classLoadered?.parent
        }
    }
    fun initData(){
        classLoadered = classLoader
    }
    fun initListener(){
        btn.setOnClickListener{
            useDexClassLoader()
        }
    }

    fun useDexClassLoader(){
        val intent = Intent()
        intent.setPackage("sourceapk.hui.com")
        val plugins:List<ResolveInfo> = packageManager.queryIntentActivities(intent,0)
        if (plugins.size <= 0){
            Log.e("liufeixuan","没有找到")
        }
        val resolveInfo:ResolveInfo = plugins.get(0)
        val activityInfo:ActivityInfo = resolveInfo.activityInfo
        val div:String = System.getProperty("path.separator")
        val packName:String = activityInfo.packageName
        val dexPath = activityInfo.applicationInfo.sourceDir
        val dexOutputDir = applicationInfo.dataDir
        val libPath = activityInfo.applicationInfo.nativeLibraryDir
        val dexClassLoader:DexClassLoader = DexClassLoader(dexPath,dexOutputDir,libPath,classLoader)
        val clazz = dexClassLoader.loadClass("$packName.PluginClass")
        val obj = clazz.newInstance()

        val action = clazz.getDeclaredMethod("invoke",java.lang.String().javaClass)
        action.invoke(obj,"test in fuction")
    }
}
