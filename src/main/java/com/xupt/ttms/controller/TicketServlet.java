package com.xupt.ttms.controller;

import com.xupt.ttms.pojo.*;
import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.util.ToResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    @PostMapping("/ticket/getTicketsByPId/{PId}")
    public Result getTicketsByPId(@PathVariable("PId") String PId){
        List<Ticket> tickets = ticketService.getTicketsByPId(PId);
        return ToResult.getResult(tickets);
    }
    @PostMapping("/LockTicket/{pId}")
    public void LockTicket( @PathVariable("pId") String pId, @RequestBody List<Seat> seat){
        ticketService.LockTicket(pId,seat);
    }
}
