package com.shipping.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTime implements Cloneable, Comparable, Serializable {
    private LocalDateTime dt;

    public DateTime() {
        this.dt = LocalDateTime.now();
    }


    public DateTime(String str) {
        this.dt = LocalDateTime.parse(str, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }


    public LocalDateTime getDate() {
        return this.dt;
    }

    public String getDateStr() {
        return dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDateTimeStr() {
        return dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }


    @Override
    public int compareTo(Object o) {
        return this.dt.compareTo((LocalDateTime) o);
    }
}
