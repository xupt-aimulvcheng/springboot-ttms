package com.xupt.ttms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xupt.ttms.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("order") Order order);

    Order selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(@Param("record") Order record);

    int payOrder(@Param("order") Order order1);

    List<Order> selectFutureOverTimeOrder();

    void updateCloseOverTimeOrder(@Param("dataId") Integer dataId);
}
