package com.intuitbrains.util;

public class ParamUtil {
    public static long parseLong(String str, long defaultVal) {
        long result = defaultVal;
        try {
            if (StringUtil.isNotEmpty(str)) {
                result = Long.parseLong(str.trim());
            }
        } catch (NumberFormatException e) {

        }
        return result;

    }
    public static int parseInt(String str, int defaultVal) {
        int result = defaultVal;
        try {
            if (StringUtil.isNotEmpty(str)) {
                result = Integer.parseInt(str.trim());
            }
        } catch (NumberFormatException e) {

        }
        return result;

    }

    public static double parseDouble(String str, double defaultVal) {
        double result = defaultVal;
        try {
            if (StringUtil.isNotEmpty(str)) {
                result = Double.parseDouble(str.trim());
            }
        } catch (NumberFormatException e) {

        }
        return result;

    }

    public static boolean parseBoolean(String str, boolean defaultVal) {
        boolean result = false;
        try {
            if (StringUtil.isNotEmpty(str)) {
                result = str.trim().equalsIgnoreCase("true")
                        || str.trim().equalsIgnoreCase("yes")
                        || str.trim().equalsIgnoreCase("on")
                        || str.trim().equalsIgnoreCase("checked");
            }
        } catch (Exception e) {

        }
        return result;

    }
    public static Boolean parseBoolean(String str) {
        Boolean result = null;
        try {
            if (StringUtil.isNotEmpty(str)) {
                result = str.trim().equalsIgnoreCase("true")
                        || str.trim().equalsIgnoreCase("yes")
                        || str.trim().equalsIgnoreCase("on")
                        || str.trim().equalsIgnoreCase("checked");
            }
        } catch (Exception e) {

        }
        return result;

    }
}
