package com.xupt.ttms.util;

import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.io.File;

public class FileUtils {
    public static long ReadVideoTime(File source) {
        long ls = new Long(0);
        String length = "";
        try {
            MultimediaObject instance = new MultimediaObject(source);
            MultimediaInfo result = instance.getInfo();
            ls = result.getDuration() / 1000;
            Integer hour = (int) (ls / 3600);
            Integer minute = (int) (ls % 3600) / 60;
            Integer second = (int) (ls - hour * 3600 - minute * 60);
            String hr = hour.toString();
            String mi = minute.toString();
            String se = second.toString();
            if (hr.length() < 2) {
                hr = "0" + hr;
            }
            if (mi.length() < 2) {
                mi = "0" + mi;
            }
            if (se.length() < 2) {
                se = "0" + se;
            }
            length = hr + ":" + mi + ":" + se;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ls;
    }
}
