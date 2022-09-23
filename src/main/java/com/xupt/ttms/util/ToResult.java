package com.xupt.ttms.util;/*
 * @author:ck
 * @param:
 * @date:2022/7/8
 * @description:
 */

import com.github.pagehelper.PageInfo;
import com.xupt.ttms.pojo.Movie;
import com.xupt.ttms.pojo.Result;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class ToResult<T> {
    public static Result getResult(PageInfo info){
        List list = info.getList();
        long total = info.getTotal();
        return Result.success(list,total);
    }
    public static Result getResult(Movie info){
        Movie list = info;
        long total = 1;
        return Result.success(list,total);
    }
    public static Result getResult(Object video){
        Object list = video;
        long total = 1;
        return Result.success(list,total);
    }

    public static String getUUID() {
        String replaceUUID = UUID.randomUUID().toString().replace("-", "");
        return replaceUUID;
    }
    public static  String getOrderNo() {
        //随机生成一位整数
        int random = (int) (Math.random()*9+1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if(hashCode<0){
            hashCode = -hashCode;
        }
        String value = valueOf + String.format("%015d", hashCode);
        return value;
    }
}