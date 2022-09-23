package com.xupt.ttms.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.Assert.*;
@SpringBootTest
public class InsiderServiceImplTest {

    @Test
    public void getUserByUsernameAndPwd() {
        System.out.println(1111);
    }

    @Test
    public void getUserByUsername() {
    }

    @Test
    public void register() {
    }

    @Test
    public void updateUserByUsernameAndPhone() {
    }
    @Test
    public void q() throws Exception {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}