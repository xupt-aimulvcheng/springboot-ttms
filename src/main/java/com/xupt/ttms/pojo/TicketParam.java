package com.xupt.ttms.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TicketParam {
    private int row;
    private int col;
}
