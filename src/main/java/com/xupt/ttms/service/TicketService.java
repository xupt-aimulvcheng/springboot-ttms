package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Seat;
import com.xupt.ttms.pojo.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTicketByPlan(List<Plan> plans);
    int insertTicket(List<Plan> plans);
    int deleteTicket(List<Plan> list);
    List<Ticket> getTicketsByPId(String pId);

    int LockTicket(String pId, List<Seat> seat);

    int UnLockTicket(String pId, List<Seat> seat);
}
