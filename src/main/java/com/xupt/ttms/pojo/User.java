package com.xupt.ttms.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Data
public class User {

    private Integer id;


    private String username;


    private String password;


    private String phone;

    private BigDecimal balance;

    public User() {
    }

    public User(String password) {
        this.password = password;
    }

    public User(Integer id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

}