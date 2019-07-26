package com.samit.utils;

import com.google.gson.Gson;

public class JsonUtils {

    private static Gson gson = new Gson();

    public static Object fromJson(String body, Class clazz) {
        return gson.fromJson(body, clazz);
    }

    public static String toJson(Object model) {
        return gson.toJson(model);
    }
}
