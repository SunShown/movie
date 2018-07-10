package com.hui.movie.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

public class TinkerManager {
    private static boolean isInstalled = false;
    private static ApplicationLike mApplike;
    public static void inStallTinker(ApplicationLike applicationLike){
        mApplike = applicationLike;
        if (isInstalled){
            return;
        }
        TinkerInstaller.install(mApplike);
        isInstalled = true;
    }

    //完成patch文件加载
    public static void loadPatch(String patch){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),patch);
        }
    }

    //通过ApplicationLink 获取context
    private static Context getApplicationContext(){
        if (mApplike != null){
            return mApplike.getApplication().getApplicationContext();
        }
        return null;
    }
}
