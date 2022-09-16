package com.xupt.ttms.service.impl;

import com.xupt.ttms.TtmsApplication;
import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Ticket;
import com.xupt.ttms.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TtmsApplication.class)
public class TicketServiceTest {
    @Autowired
    private TicketService ticketService;
    @Test
    public void getTicketByPlanTest(){
        Plan plan = new Plan(2, 3, 18, "演出计划2", "2022-08-26 02:09:00", "2022-08-26 04:08:00", "刀剑神域序列之争", "409演出厅", new BigDecimal(55));
        Plan plan1 = new Plan(2, 3, 18, "演出计划2", "2022-08-26 02:09:00", "2022-08-26 04:08:00", "刀剑神域序列之争", "409演出厅", new BigDecimal(55));
        List<Plan> list = new ArrayList<>();
        list.add(plan);
        list.add(plan1);
        for (Ticket ticket : ticketService.getTicketByPlan(list)) {
            System.out.println(ticket);
        }
    }
}
