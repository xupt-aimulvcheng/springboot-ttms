package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.Plan;
import com.xupt.ttms.pojo.Result;
import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.util.ToResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TicketServlet {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/ticket/insertTicket")
    public Result insertTicket(@RequestBody List<Plan> plans){
        int result = ticketService.insertTicket(plans);
        return ToResult.getResult(result>0?"上线成功":"上线失败");
    }
    @PostMapping("/ticket/deleteTicket")
    public Result deleteTicket(@RequestBody List<Plan> plans){
        int result = ticketService.deleteTicket(plans);
        return ToResult.getResult(result>0?"下线成功":"下线失败");
    }
}
