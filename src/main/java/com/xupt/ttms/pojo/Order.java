package com.xupt.ttms.pojo;

import com.xupt.ttms.util.ToResult;
import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Data
@Component
@ToString
public class Order {
    private Integer id;
    private String orderNo;//订单号
    private String status="0";// 0:"待支付"，1:"已支付"，2:“用户已退票“,3:"售票员已退票"
    private BigDecimal amount;//金额
    private String desc;
    private Integer userId;
    private String purchaseTime;
    private String generateTime;
    private List<Seat> seats;
}
