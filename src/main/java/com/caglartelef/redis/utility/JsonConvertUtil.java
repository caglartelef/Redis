package com.caglartelef.redis.utility;

import com.google.gson.Gson;

public class JsonConvertUtil {

    private static Gson gson = new Gson();

    public static String convertFromClassToJson(Object clazz) {
        return gson.toJson(clazz);
    }

    public static <T> T convertFromJsonToClass(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
