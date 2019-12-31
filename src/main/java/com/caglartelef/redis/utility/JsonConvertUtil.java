package com.caglartelef.redis.utility;

import com.google.gson.Gson;

/**
 * Json object and Class convert utility.
 */
public final class JsonConvertUtil {

    private final static Gson gson = new Gson();

    /**
     * From Object to Json Object
     */
    public static final String convertFromClassToJson(Object clazz) {
        return gson.toJson(clazz);
    }

    /**
     * From Json Object to Class
     */
    public static final <T> T convertFromJsonToClass(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }
}
