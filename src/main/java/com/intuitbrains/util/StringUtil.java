package com.intuitbrains.util;

public class StringUtil {
    public static String trim(String s) {
        return s != null ? s.trim() : null;
    }

    public static boolean parseBoolean(String s) {
        return (s!=null && trim(s).equalsIgnoreCase("yes"));
    }
    public static boolean isNotEmpty(String s) {
        return (s!=null && !trim(s).equalsIgnoreCase(""));
    }
}
