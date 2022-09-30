package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.*;
import com.xupt.ttms.service.OrderService;
import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.service.UserService;
import com.xupt.ttms.util.ToResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@RestController
@Slf4j
public class OrderServlet {
    @Autowired
    private Order order;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @PostMapping("/order/insertOrder/{pId}")
    public Result insertOrder(@CookieValue("username") String username, @RequestParam("amount") BigDecimal amount,@RequestBody List<Seat> list , @PathVariable("pId") String pId){
        User user =  userService.getUserByUsername(username);
        order.setUserId(user.getId());
        order.setAmount(amount);
        order.setOrderNo(ToResult.getOrderNo());
        orderService.insertOrder(order,list,pId);
        return ToResult.getResult(order);
    }
    @PostMapping("/order/payOrder")
    public Result payOrder(@RequestBody Order order1,@CookieValue("username") String username){
        return ToResult.getResult(orderService.payOrder(order1,username)>0?"支付成功":"支付失败");
    }
}
