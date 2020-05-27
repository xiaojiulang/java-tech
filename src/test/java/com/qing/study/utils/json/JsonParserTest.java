package com.qing.study.utils.json;

public class JsonParserTest {

    public static void main(String[] args) {
        String jm = "{\"aa\":100}";
        String jl = "[10,20,30]";

        System.out.println(JsonParser.changeListToJsonStr(
                JsonParser.changeJsonStrToArray(jl)
        ));
        System.out.println(JsonParser.changeMapToJsonStr(
                JsonParser.changeJsonStrToMap(jm)
        ));
    }
}
