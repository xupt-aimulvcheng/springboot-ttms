package com.xupt.ttms.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Component
@ToString
public class Order  implements Serializable {
    private static final long serialVersionUID = -6186165618109400238L;
    private Integer id;
    private String orderNo;//订单号
    private String status="0";// 0:"待支付"，1:"已支付"，2:“用户已退票“,3:"售票员已退票",-1:"已过期"
    private BigDecimal amount;//金额
    private String desc;
    private Integer userId;
    private Date purchaseTime;//订单支付时间
    private Date generateTime;//订单生成时间
    private Date expireTime;//过期时间
    private List<Seat> seats;
}
