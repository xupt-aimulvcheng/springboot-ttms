package com.xupt.ttms.pojo;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Plan {
    private Integer id;
    private String mName;
    private String hName;
    private Integer mId;
    private Integer hId;
    private String pName;
    private String startDate;
    private String endDate;
    private BigDecimal price;
    private String status="待上线";
    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", mName='" + mName + '\'' +
                ", hName='" + hName + '\'' +
                ", mId=" + mId +
                ", hId=" + hId +
                ", pName='" + pName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", price=" + price +
                ", address='" + +'\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String gethName() {
        return hName;
    }

    public void sethName(String hName) {
        this.hName = hName;
    }

    public Integer getmId() {
        return mId;
    }

    public void setmId(Integer mId) {
        this.mId = mId;
    }

    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Plan(Integer id, String mName, String hName, Integer mId, Integer hId, String pName, String startDate, String endDate, BigDecimal price, String address) {
        this.id = id;
        this.mName = mName;
        this.hName = hName;
        this.mId = mId;
        this.hId = hId;
        this.pName = pName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Plan(Integer id, String mName, String hName, Integer mId, Integer hId, String pName, String startDate, String endDate, BigDecimal price) {
        this.id = id;
        this.mName = mName;
        this.hName = hName;
        this.mId = mId;
        this.hId = hId;
        this.pName = pName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
    }

    public Plan() {
    }

    public Plan(Integer id, Integer mId, Integer hId, String pName, String startDate, String endDate,String mName,String hName,BigDecimal price) {
        this.id = id;
        this.mId = mId;
        this.hId = hId;
        this.pName = pName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mName=mName;
        this.hName=hName;
        this.price=price;
    }
}