package com.gao.scorpio.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gaobh on 2016/12/22.
 */
public class DateUtil {
    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateformat1 = new SimpleDateFormat(pattern);
        return dateformat1.format(date);
    }
}
