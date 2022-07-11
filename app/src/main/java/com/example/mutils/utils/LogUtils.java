package com.example.mutils.utils;

import android.content.Context;
import android.util.Log;

public class LogUtils {
    private static boolean open = true;//默认开启
    /**
     * 在App_onCreate中调用，log的统一开关
     */
    public LogUtils(boolean open) {
        this.open = open;
    }

    /**
     * TAG为类名的log日志
     */
    public static void logD(Context context, String msg) {
        if(open)
        Log.d(context.getClass().getSimpleName(), msg + "");
    }

    /**
     * 自定义log日志
     */
    public static void logD(String tag, String msg) {
        if(open)
            Log.d(tag, msg + "");
    }

    /**
     * TAG为类名的log日志
     */
    public static void logI(Context context, String msg) {
        if(open)
            Log.i(context.getClass().getSimpleName(), msg + "");
    }

    /**
     * 自定义log日志
     */
    public static void logI(String tag, String msg) {
        if(open)
            Log.i(tag, msg + "");
    }

    /**
     * TAG为类名的log日志
     */
    public static void logW(Context context, String msg) {
        if(open)
            Log.w(context.getClass().getSimpleName(), msg + "");
    }

    /**
     * 自定义log日志
     */
    public static void logW(String tag, String msg) {
        if(open)
            Log.w(tag, msg + "");
    }

    /**
     * TAG为类名的log日志
     */
    public static void logE(Context context, String msg) {
        if(open)
            Log.e(context.getClass().getSimpleName(), msg + "");
    }

    /**
     * 自定义log日志
     */
    public static void logE(String tag, String msg) {
        if(open)
            Log.e(tag, msg + "");
    }
}
