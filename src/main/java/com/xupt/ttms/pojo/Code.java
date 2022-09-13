package com.xupt.ttms.pojo;

import org.springframework.stereotype.Component;

/**
 * 处理信息
 */
@Component
public class Code {
    String info;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Code(String info, String type) {
        this.info = info;
        this.type = type;
    }

    public Code() {
    }

    public Code(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
