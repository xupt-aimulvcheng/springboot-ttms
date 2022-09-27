package com.xupt.ttms.pojo;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Video  implements Serializable {
    private static final long serialVersionUID = -291206511224461066L;
    private Integer id;
    private Integer mId;
    private String mSrc;
    private String vSrc;
    private long len;
    private String desc;

    public Video(Integer id, Integer mId, String mSrc, String vSrc, long len, String desc) {
        this.id = id;
        this.mId = mId;
        this.mSrc = mSrc;
        this.vSrc = vSrc;
        this.len = len;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public String getmSrc() {
        return mSrc;
    }

    public void setmSrc(String mSrc) {
        this.mSrc = mSrc;
    }

    public String getvSrc() {
        return vSrc;
    }

    public void setvSrc(String vSrc) {
        this.vSrc = vSrc;
    }

    public long getLen() {
        return len;
    }

    public void setLen(long len) {
        this.len = len;
    }

    public Video() {
    }

    public Video(Integer id, Integer mId, String mSrc, String vSrc, Integer len) {
        this.id = id;
        this.mId = mId;
        this.mSrc = mSrc;
        this.vSrc = vSrc;
        this.len = len;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", mId=" + mId +
                ", mSrc='" + mSrc + '\'' +
                ", vSrc='" + vSrc + '\'' +
                ", len=" + len +
                '}';
    }
}
