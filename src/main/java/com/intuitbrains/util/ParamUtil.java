package com.intuitbrains.util;

public class ParamUtil {
    public static long parseLong(String str, long defaultVal) {
        long result = defaultVal;
        try {
            if (str != null) {
                result = Long.parseLong(str.trim());
            }
        } catch (NumberFormatException e) {

        }
        return result;

    }
    public static int parseInt(String str, int defaultVal) {
        int result = defaultVal;
        try {
            if (str != null) {
                result = Integer.parseInt(str.trim());
            }
        } catch (NumberFormatException e) {

        }
        return result;

    }

    public static boolean parseBoolean(String str, boolean defaultVal) {
        boolean result = false;
        try {
            if (str != null) {
                result = str.trim().equalsIgnoreCase("true")
                        || str.trim().equalsIgnoreCase("on")
                        || str.trim().equalsIgnoreCase("checked");
            }
        } catch (Exception e) {

        }
        return result;

    }
}
