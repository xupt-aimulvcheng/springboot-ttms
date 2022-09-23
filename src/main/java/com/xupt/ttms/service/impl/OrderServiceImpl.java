package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.OrderMapper;
import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int insertOrder(Order order1) {
        return orderMapper.insert(order1);
    }
}
