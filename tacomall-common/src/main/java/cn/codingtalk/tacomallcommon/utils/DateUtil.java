package cn.codingtalk.tacomallcommon.utils;


import java.util.Date;

import org.joda.time.DateTime;

public class DateUtil {
    public static Date addHours(Date date, int hours) {
        DateTime dateTime = new DateTime(date);
        return dateTime.plusHours(hours).toDate();
    }
}
