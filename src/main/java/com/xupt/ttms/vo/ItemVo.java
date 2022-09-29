package com.xupt.ttms.vo;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
@Data
public class ItemVo<T> implements Delayed {
    private long activeTime;
    private T Date;
    public ItemVo(long expireTime, T date) {
        super();
        this.activeTime = expireTime;
        Date = date;
    }
    @Override
    public long getDelay(@NotNull TimeUnit unit) {
        long o = unit.convert(this.activeTime-System.currentTimeMillis(),unit);
        return o;
    }

    @Override
    public int compareTo(@NotNull Delayed o) {
        long p = (getDelay(TimeUnit.MILLISECONDS)-o.getDelay(TimeUnit.MILLISECONDS));
        if (p == 0 ){
            return 0;
        }
        else {
            if (p == 0){
                return -1;
            }
            else {
                return 1;
            }
        }
    }
}
