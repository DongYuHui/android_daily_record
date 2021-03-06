package com.kyletung.androiddailyrecord.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * All rights reserved by Author<br>
 * Author: Dong YuHui<br>
 * Email: <a href="mailto:dyh920827@gmail.com">dyh920827@gmail.com</a><br>
 * Blog: <a href="http://www.kyletung.com">www.kyletung.com</a><br>
 * Create Time: 2016/06/27 at 15:27<br>
 * <br>
 * 封装 GSon 库，用于处理 Json 格式
 */
public class JsonUtil {

    private static JsonUtil mUtil;

    private Gson mJson;

    private JsonUtil() {
        //no instance
        mJson = new GsonBuilder().create();
    }

    public static JsonUtil getInstance() {
        if (mUtil == null) mUtil = new JsonUtil();
        return mUtil;
    }

    public String toJson(Object object) {
        return mJson.toJson(object);
    }

    public <T> T fromJson(String content, Class<T> cls) {
        return mJson.fromJson(content, cls);
    }

    @SuppressWarnings("unchecked")
    public <T> ArrayList<T> toList(String content) {
        return mJson.fromJson(content, ArrayList.class);
    }

}
