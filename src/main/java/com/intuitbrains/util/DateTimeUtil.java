package com.intuitbrains.util;

import com.intuitbrains.model.common.Duration;
import com.intuitbrains.model.common.DurationType;

import java.time.*;
import java.util.Date;

import static java.time.temporal.ChronoUnit.*;

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

        return zonedIST.toLocalDateTime();
    }

    public static LocalDateTime getNowDateTime() {
        // your local date/time with no timezone information
        LocalDateTime localNow = LocalDateTime.now();
        // setting UTC as the timezone
        ZonedDateTime zonedUTC = localNow.atZone(ZoneId.of(UTC));
        // converting to IST
        ZonedDateTime zonedIST = zonedUTC.withZoneSameInstant(ZoneId.of(IST));

        return zonedIST.toLocalDateTime();
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

    public static long differenceInMonths(LocalDate dateBefore, LocalDate dateAfter) {
        return MONTHS.between(dateBefore, dateAfter);
    }
    public static long differenceInDays(LocalDate dateBefore, LocalDate dateAfter) {
        return DAYS.between(dateBefore, dateAfter);
    }
    public static Period differenceInPeriod(LocalDate dateBefore, LocalDate dateAfter) {
        return Period.between(dateBefore, dateAfter);
        //int years = age.getYears();
        //int months = age.getMonths();
    }

    public static LocalDate calculateExpiryDate(Duration duration, LocalDate fromDate) {
        LocalDate expiryDateTime = LocalDate.of(fromDate.getYear(), fromDate.getMonth(), fromDate.getDayOfMonth());
        if(duration.getDurationType().equals(DurationType.MONTHS)) {
            expiryDateTime.plusMonths(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.DAYS)) {
            expiryDateTime.plusDays(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.YEARS)) {
            expiryDateTime.plusYears(duration.getDuration());
        }

        else if(duration.getDurationType().equals(DurationType.WEEKS)) {
            expiryDateTime.plusWeeks(duration.getDuration());
        }
        return expiryDateTime;
    }

    public static LocalDateTime calculateExpiryDateTime(Duration duration, LocalDateTime fromDateTime) {
        LocalDateTime expiryDateTime = LocalDateTime.of(fromDateTime.getYear(), fromDateTime.getMonth(),
                fromDateTime.getDayOfMonth(), fromDateTime.getHour(), fromDateTime.getMinute(), fromDateTime.getSecond());
        if(duration.getDurationType().equals(DurationType.MONTHS)) {
            expiryDateTime.plusMonths(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.DAYS)) {
            expiryDateTime.plusDays(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.YEARS)) {
            expiryDateTime.plusYears(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.HOURS)) {
            expiryDateTime.plusHours(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.WEEKS)) {
            expiryDateTime.plusWeeks(duration.getDuration());
        }
        else if(duration.getDurationType().equals(DurationType.MINS)) {
            expiryDateTime.plusMinutes(duration.getDuration());
        }
        return expiryDateTime;
    }
}
