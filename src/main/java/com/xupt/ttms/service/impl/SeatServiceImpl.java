package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.SeatMapper;
import com.xupt.ttms.mapper.TicketMapper;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<Seat> getSeatList(Integer studioId) {
        return seatMapper.getSeatList(studioId);
    }

    @Override
    public int updateSeats(List<Seat> seats) {
        //获取每个seat的id并进行设置
        for (int i = 0; i < seats.size(); i++) {
            Integer id = seatMapper.getId(seats.get(i));
            seats.get(i).setId(id);
        }
        int ticketResult = 0;
        if (ticketMapper.getTicketBySeats(seats)>0){  //表里有要修改的数据
            ticketResult =ticketMapper.updateTicket(seats);
        }
        return seatMapper.updateSeats(seats)+ticketResult;
    }
}