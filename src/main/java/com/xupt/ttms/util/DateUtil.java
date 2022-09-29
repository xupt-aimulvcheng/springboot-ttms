package com.xupt.ttms.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";

    public static Date getDate(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        try {
            return sdf.parse(sdf.format(date));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 格式化日期
     *
     * @param date
     * @return
     */
    public static String formatDate(Date date,String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 在日期date上增加amount天 。
     *
     * @param date   处理的日期，非null
     * @param amount 要加的天数(正数)/要减去的天数(负数)
     */
    public static Date dealDays(Date date, int amount) {
        Calendar now = Calendar.getInstance();
        now.setTime(date);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + amount);
        return now.getTime();
    }
    public static String TimeAdd(String oldTime,String add){
        int addMit = Integer.valueOf(add);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse(oldTime);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Date expireTime = new Date(date.getTime() + addMit*60*1000);
        String newTime = df.format(expireTime);
        return newTime;
    }
}