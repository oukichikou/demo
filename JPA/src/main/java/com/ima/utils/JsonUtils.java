package com.ima.utils;

import com.alibaba.fastjson.JSONArray;

/**
 * Created by ${符柱成} on 2017/3/28.
 */
public class JsonUtils {

    public static String objectToJson(Object data) {
        String json = JSONArray.toJSONString(data);
        return json;
    }
}
