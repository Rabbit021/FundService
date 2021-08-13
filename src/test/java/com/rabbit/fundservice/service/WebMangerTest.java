package com.rabbit.fundservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WebMangerTest {
    @Autowired WebManger webManger;

    @Test
    void getString() {
        String str = webManger.getString("http://api.fund.eastmoney.com/ztjj/GetZTJJList?callback=jQuery183040080088148830884_1628765712487&tt=2&dt=syl&st=ZDF&_=1628765722209");
        System.out.println(str);
    }
}