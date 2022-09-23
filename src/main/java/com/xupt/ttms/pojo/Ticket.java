package com.xupt.ttms.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@Data
public class Ticket {
    private Integer id;
    private Integer seatId;
    private Integer planId;
    private BigDecimal ticketPrice;
    private Integer status;                  //1代表可购买，0代表对应的座位已损坏，2代表已购买
    private LocalDateTime ticketLockTome;  //购买时间
    //对应座位的行列号以便前端展示
    private Integer row;
    private Integer col;
    private Integer orderId;
}