package com.example.mymvp.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
    private static final Locale LOCALE = Locale.CHINA;
    public static String format(Date date, String s) {
        return new SimpleDateFormat(s, LOCALE).format(date);
    }
}
