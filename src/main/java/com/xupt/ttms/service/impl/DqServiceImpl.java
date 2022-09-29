package com.xupt.ttms.service.impl;

import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.service.OrderService;
import com.xupt.ttms.vo.ItemVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.concurrent.DelayQueue;
@Service
@Slf4j
public class DqServiceImpl {
    @Resource
    private OrderService orderService;
    private static DelayQueue<ItemVo<Order>> delayQueue = new DelayQueue<>();

    //将订单放进延迟队列
    public void putIntoQueue(Order order, long expireTime) {
        ItemVo<Order> itemVo = new ItemVo<>(expireTime, order);
        delayQueue.put(itemVo);
    }

    private class OrderThread implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    ItemVo<Order> take = delayQueue.take();
                    log.info("您取出来的订单为"+take);
                    if (null != take) {
                        Order order = take.getDate();
                        log.info("您取出来的订单为"+order);
                        Order order1 = orderService.selectByPrimaryKey(order.getId());
                        log.info(String.valueOf(order1));
                        if ("0".equals(order1.getStatus())) {
                            orderService.updateCloseOverTimeOrder(order1.getId());
                            log.info("您的订单已超时");
                        }
                        else {
                            log.info("您的订单"+order+"未过期请继续支付");
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private Thread thread;

    @PostConstruct
    public void init() {
        thread = new Thread(new OrderThread());
        thread.start();
    }

    @PreDestroy
    public void close() {
        thread.interrupt();
    }
}