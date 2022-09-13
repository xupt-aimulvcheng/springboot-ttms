package com.xupt.ttms.pojo;

import com.xupt.ttms.util.ToResult;

import java.math.BigDecimal;

public class Order {
    private Integer id;
    private String orderNo;
    private String status;// "待支付"，"已支付"，“已退单
    private BigDecimal amount;//金额
    private String desc;
    private Integer ticketId;// ”对应票id"

    public Integer getId() {
        return id;
    }

    public Order() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo() {
        this.orderNo = ToResult.getUUID();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }
}
