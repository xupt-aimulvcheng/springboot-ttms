package com.xupt.ttms.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

@Component
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6485342238647844724L;
    private Integer id;


    private String username;


    private String password;


    private String phone;

    private BigDecimal balance;
    @TableLogic
    private Integer isDeleted;

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