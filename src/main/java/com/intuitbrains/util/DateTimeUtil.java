package com.intuitbrains.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class DateTimeUtil {
    public static LocalDate convertToLocalDate(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime().toLocalDate();
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
        return new java.sql.Timestamp(
                dateToConvert.getTime()).toLocalDateTime();
    }
}
