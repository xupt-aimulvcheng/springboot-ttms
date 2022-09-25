package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.OrderMapper;
import com.xupt.ttms.mapper.TicketMapper;
import com.xupt.ttms.mapper.UserMapper;
import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private TicketMapper ticketMapper;
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insertOrder(Order order1, List<Seat> list, String pId) {
        int orderAffect = orderMapper.insert(order1);
        int ticketAffect = ticketMapper.updateOrderNo(list,pId,order1.getId());
        return orderAffect+ticketAffect;
    }

    @Override
    public int payOrder(Order order1,String username) {
        return orderMapper.payOrder(order1)+userMapper.payOrder(order1.getAmount(),username);
    }
}
