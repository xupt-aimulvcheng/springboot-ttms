package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.OrderMapper;
import com.xupt.ttms.mapper.TicketMapper;
import com.xupt.ttms.mapper.UserMapper;
import com.xupt.ttms.pojo.Order;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.service.OrderService;
import com.xupt.ttms.util.DateUtil;
import com.xupt.ttms.util.RedisUtil;
import com.xupt.ttms.util.TypeCasting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private DqServiceImpl dqService;
    @Override
    public int insertOrder(Order order1, List<Seat> list, String pId) {
        //获取当前时间
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date nowTime = TypeCasting.StringToDate(dateFormat.format(date));
        order1.setGenerateTime(nowTime);
        //当前30分钟后的时间
        String expire_time = DateUtil.TimeAdd(dateFormat.format(date), "30");
        order1.setExpireTime(TypeCasting.StringToDate(expire_time));
        //插入数据
        int orderAffect = orderMapper.insert(order1);
        int ticketAffect = ticketMapper.updateOrderNo(list,pId,order1.getId());
        Order order = orderMapper.selectByPrimaryKey(order1.getId());
        //获取超时时间并转换为long类型数据
        long exPreTime = order.getExpireTime().getTime();
        dqService.putIntoQueue(order1,exPreTime);
        return orderAffect+ticketAffect;
    }

    @Override
    public int payOrder(Order order1,String username) {
        int result = orderMapper.payOrder(order1)+userMapper.payOrder(order1.getAmount(),username);
        return result;
    }

    @Override
    public void updateCloseOverTimeOrder(Integer dataId) {
        orderMapper.updateCloseOverTimeOrder(dataId);
        ticketMapper.deleteOrder(dataId);
    }

    /**
     * 查询未支付且未超时的订单信息
     * @return
     */
    @Override
    public List<Order> selectFutureOverTimeOrder() {
        return orderMapper.selectFutureOverTimeOrder();
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }
    @PostConstruct
    public void findOverTime(){
        //程序加载查询所有的未支付的订单
        for (Order order : selectFutureOverTimeOrder()) {
            Date expireTime = order.getExpireTime();
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date nowTime = TypeCasting.StringToDate(dateFormat.format(date));
            if (expireTime.compareTo(nowTime)<=0){ //超时时间小于等于现在的时间即超时
                updateCloseOverTimeOrder(order.getId());
            }
        }
    }
}
