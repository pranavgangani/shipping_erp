package com.shipping.util;

import java.util.List;

public class ListUtil {

    public static boolean isNotEmpty(List list) {
        if (list != null && !list.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
