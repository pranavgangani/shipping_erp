package com.intuitbrains.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DateTimeUtil {
    private final static String UTC = "UTC";
    private final static String IST = "Asia/Kolkata";
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        // your local date/time with no timezone information
        //LocalDate localNow = new java.sql.Timestamp(dateToConvert.getTime()).toLocalDateTime().toLocalDate();
        // setting UTC as the timezone
        //ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of(UTC));
        // converting to IST
        //ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of(IST));
        //return  zonedIST.toLocalDate();

        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime().toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTime(Date dateTimeToConvert) {
        // your local date/time with no timezone information
        LocalDateTime localNow = new java.sql.Timestamp(dateTimeToConvert.getTime()).toLocalDateTime();
        // setting UTC as the timezone
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of(UTC));
        // converting to IST
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of(IST));

        return  zonedIST.toLocalDateTime();
    }

    public static LocalDate convertToDate(String date) {
        date = date.replace(",", " ");
        String[] dobStr = date.split(" ");
        int month = getMonthNumber(dobStr[0]);
        int day = ParamUtil.parseInt(dobStr[1], -1);
        int year = ParamUtil.parseInt(dobStr[2], -1);
        return LocalDate.of(year, month, day);
    }

    private static int getMonthNumber(String month) {
        int monthNum;
        switch (month.toLowerCase()) {
            case "jan":
                monthNum = 1;
                break;
            case "feb":
                monthNum = 2;
                break;
            case "mar":
                monthNum = 3;
                break;
            case "apr":
                monthNum = 4;
                break;
            case "may":
                monthNum = 5;
                break;
            case "jun":
                monthNum = 6;
                break;
            case "jul":
                monthNum = 7;
                break;
            case "aug":
                monthNum = 8;
                break;
            case "sep":
                monthNum = 9;
                break;
            case "oct":
                monthNum = 10;
                break;
            case "nov":
                monthNum = 11;
                break;
            case "dec":
                monthNum = 12;
                break;
            default:
                monthNum = 0;
                break;
        }
        return monthNum;
    }
}
