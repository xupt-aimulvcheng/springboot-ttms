package com.xupt.ttms.pojo;/*
 * @author:ck
 * @param:
 * @date:2022/7/10
 * @description:
 */

import org.springframework.stereotype.Component;

@Component
public class Action {
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
