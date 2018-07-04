package com.hui.movie.base;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;
import com.hui.movie.Util.DeviceUtiKt;

import java.io.IOException;

public class AndFixManagerJava {
    private static AndFixManagerJava instance ;
    private static Context context;
    private PatchManager patchManager;
    public static AndFixManagerJava getInstance(Context mcontext) {
        context = mcontext;
        if (instance == null){
            synchronized (AndFixManagerJava.class){
                if (instance == null){
                    instance = new AndFixManagerJava();
                }
            }
        }
        return instance;
    }

    /**
     * 初始化
     */
    public void initPatchManager(){
        patchManager = new PatchManager(context);
        patchManager.init(DeviceUtiKt.getVersionNumber(context));
        patchManager.loadPatch();
    }

    public void addPatch(String path){
        if (patchManager != null){
            patchManager = new PatchManager(context);
        }
        try {
            patchManager.addPatch(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
