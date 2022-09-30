package com.xupt.ttms.service.impl;

import com.xupt.ttms.mapper.PlanMapper;
import com.xupt.ttms.mapper.TicketMapper;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.Ticket;
import com.xupt.ttms.service.SeatService;
import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.util.RedisUtil;
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
    private TicketMapper ticketMapper;
    @Autowired
    private PlanMapper planMapper;

    private String keys = "ticket_*";
    private String keys1 = "plan_*";
    /**
     * 通过某个演出计划得到单个的票集合
     * @param plans  待上线的演出计划
     * @return  所有生成的票集合
     */
    @Override
    public List<Ticket> getTicketByPlan(List<Plan> plans) {
        List<Ticket> list = new ArrayList<>();
        //待上线的演出计划只有一个
        if (plans.size() == 1) {
            Plan plan = plans.get(0);
            List<Seat> seatList = seatService.getSeatList(plan.gethId());
            for (Seat seat : seatList) {
                Ticket ticket = new Ticket();
                Integer seatID = seat.getId();
                Integer status = seat.getStatus();
                ticket.setSeatId(seatID);
                ticket.setStatus(status);
                ticket.setTicketPrice(plan.getPrice());
                ticket.setPlanId(plan.getId());
                list.add(ticket);
            }
        }
        //待上线的演出计划有多个
        else {
            for (Plan plan : plans) {
                List<Seat> seatList = seatService.getSeatList(plan.gethId());
                for (int j = 0; j < seatList.size(); j++) {
                    Ticket ticket = new Ticket();
                    Integer seatID = seatList.get(j).getId();
                    Integer status = seatList.get(j).getStatus();
                    ticket.setSeatId(seatID);
                    ticket.setStatus(status);
                    ticket.setTicketPrice(plan.getPrice());
                    ticket.setPlanId(plan.getId());
                    list.add(ticket);
                }
            }
        }
        return list;
    }
    @Override
    public int insertTicket(List<Plan> plans) {
        List<Ticket> list = getTicketByPlan(plans);
        int result = ticketMapper.insertTicker(list)+planMapper.onlinePlan(plans);
        if (result>0){
            RedisUtil.deleteCaChe(keys);
            RedisUtil.deleteCaChe(keys1);
        }
        return result;
    }

    @Override
    public int deleteTicket(List<Plan> list) {
        int i = ticketMapper.deleteTicket(list) + planMapper.offline(list);
        if (i>-1){
            RedisUtil.deleteCaChe(keys);
            RedisUtil.deleteCaChe(keys1);
        }
        return i;
    }

    @Override
    public List<Ticket> getTicketsByPId(String pId) {
        return ticketMapper.getTicketsByPId(pId);
    }

    /**
     * 锁定票
     * @param pId
     * @param seat
     * @return
     */
    @Override
    public synchronized int LockTicket(String pId, List<Seat> seat) {
        int i = ticketMapper.LockTicket(pId, seat);
        if (i>=1) {
            RedisUtil.deleteCaChe(keys);
            RedisUtil.deleteCaChe(keys1);
        }
        return i;
    }

    @Override
    public synchronized int UnLockTicket(String pId, List<Seat> seat) {
        int i = ticketMapper.UnLockTicket(pId, seat);
        if (i>=1){
            RedisUtil.deleteCaChe(keys);
            RedisUtil.deleteCaChe(keys1);
        }
        return i;
    }
}
