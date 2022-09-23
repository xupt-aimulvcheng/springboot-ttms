package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.pojo.User;
import com.xupt.ttms.service.OrderService;
import com.xupt.ttms.util.ToResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {
    @Autowired
    private Order order;
    @Autowired
    private OrderService orderService;
    public Result insertOrder(HttpSession session,@RequestBody Order order1){
        User user = (User) session.getAttribute("user");
        order1.setId(user.getId());
        order1.setOrderNo(ToResult.getOrderNo());
        orderService.insertOrder(order1);
        return ToResult.getResult(order1);
    }
}
