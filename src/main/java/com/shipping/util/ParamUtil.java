package com.shipping.util;

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
}
