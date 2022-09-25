package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.Ticket;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketMapper {
    int insertTicker(@Param("list") List<Ticket> list);
    int deleteTicket(@Param("list") List<Plan> list);
    int deleteTicketByPIds(@Param("pIds") String pIds);

    /**
     * 当座位修改后对应票的状态也要改变
     * @return
     */
    int updateTicket(@Param("seats") List<Seat> seats);
    /**
     * 判断票表里是否有对应座位的id
     */
    int getTicketBySeats(@Param("seats") List<Seat> seats);

    List<Ticket> getTicketsByPId(@Param("pId") String pId);

    int LockTicket(@Param("pId") String pId,@Param("seats") List<Seat> seat);

    int UnLockTicket(@Param("pId") String pId,@Param("seats") List<Seat> seat);

    int updateOrderNo(@Param("seats") List<Seat> list, @Param("pId") String pId, @Param("orderId") Integer orderId);
}