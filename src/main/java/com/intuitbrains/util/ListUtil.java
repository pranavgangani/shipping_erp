package com.intuitbrains.util;

import java.util.List;

public class ListUtil {

    public static boolean isNotEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static Object getFirstItem(List list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return false;
        }
    }

    public static Object getLastItem(List list) {
        if (list != null && !list.isEmpty()) {
            return list.get(list.size() - 1);
        } else {
            return false;
        }
    }

    public static boolean isEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
