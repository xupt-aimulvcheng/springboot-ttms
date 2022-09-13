package com.xupt.ttms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class TypeCasting {
    public static LocalDateTime formatStringToLocalDateTime(String date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, dtf);
    }

    //1.LocalDateTime转为"yyyy/MM/dd"
    public static String formatLocalDateTimeString1(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(dtf);
    }

    //2.LocalDateTime转为"yyyy-MM-dd HH:mm"
    public static String formatLocalDateTimeString(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return date.format(dtf);
    }
    //2.LocalDateTime转为"yyyy-MM-dd HH:mm:ss"
    public static String formatLocalDateTimeStringSe(LocalDateTime date) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(dtf);
    }

    //3.将"yyyy-MM-dd HH:mm:ss"转化为"yyyy-MM-dd HH:mm"
    public static String formatStringToString(String date) {
        String result = "";
        char[] chars = date.toCharArray();
        for (int i = 0; i < chars.length - 3; i++) {
            result += chars[i];
        }
        return result;
    }
    public static Date StringToDate(String str) {
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = ft.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //将list集合转为字符串
    public static <T> String ListToStr(List<T> list) {
        StringBuffer sb = new StringBuffer();
        if (!list.isEmpty()) {
            for (int i = 0; i <= list.size() - 1; i++) {
                if (i < list.size() - 1) {
                    sb.append(list.get(i) + ",");
                } else {
                    sb.append(list.get(i));
                }
            }
        }
        return sb.toString();
    }
}