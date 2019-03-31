package com.app.admin.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: liucaiwen
 * @date: 2019/3/29 00:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Before
    public void init() {
        System.out.println("开始测试-----------------");

    }
    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }


    @After
    public void after() {
        System.out.println("测试结束-----------------");

    }

}
