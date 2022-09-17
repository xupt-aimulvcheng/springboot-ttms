package com.xupt.ttms.mapper;

import com.xupt.ttms.pojo.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SeatMapper {
    public List<Seat> getSeatList(@Param("studioId") Integer studioId);
    /**
     * 批量添加座位
     * @param seat
     * @return
     */
    int insertSeat(@Param("seat") List<Seat> seat);
    int updateSeats(@Param("seats") List<Seat> seats);
    //查询所有要修改的座位的id
    Integer getId(@Param("seat") Seat seat);
    //更新选中座位后票的状态
    int updateTicket(List<Seat> seats);
}
