package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Seat;

import java.util.List;

public interface SeatService {
    public List<Seat> getSeatList(Integer studyId);

    int updateSeats(List<Seat> seats);
}
