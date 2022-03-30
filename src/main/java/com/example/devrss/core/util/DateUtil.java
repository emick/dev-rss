package com.example.devrss.core.util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class DateUtil {

    public static Date tryParseJpaBuddyDate(String date) {
        return toJavaUtil(tryParseEnglishDate(date, "MMMM dd, yyyy"));
    }

    public static Date tryParseGradleDate(String date) {
        return toJavaUtil(tryParseEnglishDate(date, "MMM dd, yyyy"));
    }

    public static Date tryParseMavenCentralDate(String date) {
        YearMonth yearMonth =  YearMonth.parse(date, DateTimeFormatter.ofPattern("MMM, yyyy", Locale.ENGLISH));
        return toJavaUtil(yearMonth.atDay(1));
    }

    public static LocalDate tryParseEnglishDate(String date, String format) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(format, Locale.ENGLISH));
    }

    public static Date toJavaUtil(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
