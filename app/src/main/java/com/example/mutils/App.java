package com.example.mutils;

import android.app.Application;
import android.content.Context;

/**
 * @author: lutong
 * @Time: 2022/7/8  17:18
 * @Description:This is App
 */
public class App extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }
    public static Context getContexts(){
        return context;
    }
}
