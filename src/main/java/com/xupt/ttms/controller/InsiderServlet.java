package com.xupt.ttms.controller;/*
 * @author:ck
 * @param:
 * @date:2022/7/7
 * @description:
 */

import com.xupt.ttms.service.InsiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class InsiderServlet {
    @Autowired
    private InsiderService insiderService;
}
