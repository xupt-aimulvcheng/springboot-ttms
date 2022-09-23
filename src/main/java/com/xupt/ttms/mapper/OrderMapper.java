package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("order") Order order);

    Order selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKey(@Param("record") Order record);
}
