package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.pojo.Seat;

import java.util.List;

public interface OrderService {
    int insertOrder(Order order1, List<Seat> list, String pId);

    int payOrder(Order order1, String username);

    void updateCloseOverTimeOrder(Integer dataId);

    List<Order> selectFutureOverTimeOrder();

    Order selectByPrimaryKey(Integer id);
}
