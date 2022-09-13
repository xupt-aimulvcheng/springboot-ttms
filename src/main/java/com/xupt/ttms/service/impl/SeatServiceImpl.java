package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.SeatMapper;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private /*static*/ SeatMapper seatMapper;

    /* {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        seatMapper = sqlSession.getMapper(SeatMapper.class);
    }*/

    @Override
    public List<Seat> getSeatList(Integer studyId) {
        return seatMapper.getSeatList(studyId);
    }

    @Override
    public int updateSeats(List<Seat> seats) {
        //获取每个seat的id并进行设置
        for (int i = 0; i < seats.size(); i++) {
            Integer id = seatMapper.getId(seats.get(i));
            seats.get(i).setId(id);
        }
//        seatMapper.updateTicket(seats);
        return seatMapper.updateSeats(seats);
    }
}
