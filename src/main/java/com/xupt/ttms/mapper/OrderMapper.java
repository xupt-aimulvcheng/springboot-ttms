package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OrderMapper {
    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(@Param("record") Order record);

    int insertSelective(@Param("record") Order record);

    Order selectByPrimaryKey(@Param("id") Integer id);

    int updateByPrimaryKeySelective(@Param("record") Order record);

    int updateByPrimaryKey(@Param("record") Order record);
}
