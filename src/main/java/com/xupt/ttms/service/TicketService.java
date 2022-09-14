package com.xupt.ttms.service;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getTicketByPlan(Plan plan);
}
