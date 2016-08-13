package com.itheima.zhbj21.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 缓存工具类
 */
public class CacheUtils {
    private static SharedPreferences sp;
    private static final String SP_NAME = "zhbj21";

    public static SharedPreferences getPreference(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        }
        return sp;
    }

    //设置需要缓存的Boolean类型值
    public static void setBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = getPreference(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    //获取缓存中的Boolean值,没有的话默认值是false
    public static boolean getBoolean(Context context, String key) {
        SharedPreferences sp = getPreference(context);
        return sp.getBoolean(key, false);
    }

    //获取缓存中的Boolean值,没有的话默认值是defValue
    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getPreference(context);
        return sp.getBoolean(key, defValue);
    }

}
