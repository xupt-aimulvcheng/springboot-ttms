package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.TicketMapper;
import com.xupt.ttms.pojo.Hall;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.Ticket;
import com.xupt.ttms.service.HallService;
import com.xupt.ttms.service.PlanService;
import com.xupt.ttms.service.SeatService;
import com.xupt.ttms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private SeatService seatService;
    @Autowired
    private PlanService planService;
    @Autowired
    private TicketMapper ticketMapper;

    /**
     * 通过某个演出计划得到单个的票集合
     * @param plan
     * @return
     */
    @Override
    public List<Ticket> getTicketByPlan(Plan plan) {
        List<Ticket> list = new ArrayList<>();
        List<Seat> seatList = seatService.getSeatList(plan.gethId());
        for (int i = 0; i < seatList.size(); i++) {
            Ticket ticket = new Ticket();
            Integer seatID=seatList.get(i).getId();
            Integer status = seatList.get(i).getStatus();
            ticket.setSeatId(seatID);
            ticket.setStatus(status);
            ticket.setTicketPrice(plan.getPrice());
            ticket.setPlanId(plan.getId());
            list.add(ticket);
        }
        return list;
    }
}
