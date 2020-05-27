package com.qing.study.utils.file;

/**
 * 根据输入数据，按照指定类型转换并输出
 */
public class JavaObject {

    public static boolean changeBaseTypeToBoolean(Object value) {
        if (value instanceof String) {
            return Boolean.parseBoolean(changeBaseTypeToString(value));
        }
        return (boolean) value;
    }

    public static byte changeBaseTypeToByte(Object value) {
        if (value instanceof String) {
            return Byte.parseByte(changeBaseTypeToString(value));
        }
        return (byte) value;
    }

    public static short changeBaseTypeToShort(Object value) {
        if (value instanceof String) {
            return Short.parseShort(changeBaseTypeToString(value));
        }
        return (short) value;
    }

    public static int changeBaseTypeToInteger(Object value) {
        if (value instanceof String) {
            return Integer.parseInt(changeBaseTypeToString(value));
        }
        return (int) value;
    }

    public static long changeBaseTypeToLong(Object value) {
        if (value instanceof String) {
            return Long.parseLong(changeBaseTypeToString(value));
        }
        return (long) value;
    }

    public static float changeBaseTypeToFloat(Object value) {
        if (value instanceof String) {
            return Float.parseFloat(changeBaseTypeToString(value));
        }
        return (float) value;
    }

    public static double changeBaseTypeToDouble(Object value) {
        if (value instanceof String) {
            return Double.parseDouble(changeBaseTypeToString(value));
        }
        return (double) value;
    }

    public static String changeBaseTypeToString(Object value) {
        return String.valueOf(value);
    }
}
