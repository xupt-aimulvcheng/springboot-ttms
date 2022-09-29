package com.xupt.ttms.pojo;

import lombok.Data;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.Date;
@Data
public class ItemDelayed<T> implements Delayed {

    /**延迟30分钟*/
    private final static long DELAY = 1 * 60 * 1000L;
    /**数据id*/
    private Integer dataId;
    /**开始时间*/
    private long startTime;
    /**到期时间*/
    private long expire;
    /**创建时间*/
    private Date now;
    /**泛型data*/
    private T data;
    
    public ItemDelayed(Integer dataId, long startTime, long secondsDelay) {
        super();
        this.dataId = dataId;
        this.startTime = startTime;
        this.expire = startTime + (secondsDelay * 1000);
        this.now = new Date();
    }

    public ItemDelayed(Integer dataId, long startTime) {
        super();
        this.dataId = dataId;
        this.startTime = startTime;
        this.expire = startTime + DELAY;
        this.now = new Date();
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }
}