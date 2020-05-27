package com.qing.study.utils.json;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Map;

public class JsonParser {

    /**
     * 将json字符串转成Map java对象
     * @param json
     *          字符串
     * @return
     *          只对jason解析，只返回Map
     * @throws ClassCastException
     *          返回其他类型，会抛错
     */
    public static Map<String, Object> changeJsonStrToMap(String json) throws ClassCastException {
        return JSON.parseObject(json);
    }

    /**
     * 将json字符串转成List java对象
     * @param json
     *          字符串
     * @return
     *          只对jason解析，只返回List
     * @throws ClassCastException
     *          返回其他类型，会抛错
     */
    public static List<Object> changeJsonStrToArray(String json) throws ClassCastException {
        return JSON.parseArray(json);
    }

    /**
     * 将Map java对象转成json字符串
     * @param map
     *          Map对象
     * @return
     *          string
     */
    public static String changeMapToJsonStr(Map<String, Object> map) {
        return JSON.toJSONString(map);
    }

    /**
     * 将List java对象转成json字符串
     * @param list
     *          list对象
     * @return
     *          string
     */
    public static String changeListToJsonStr(List<Object> list) {
        return JSON.toJSONString(list);
    }
}
