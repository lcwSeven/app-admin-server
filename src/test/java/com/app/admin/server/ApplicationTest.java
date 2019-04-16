package com.app.admin.server;

import com.app.admin.server.bean.AppDataManager;
import com.app.admin.server.dao.AppDataManagerMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void test() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("123456"));
    }

    @Autowired
    private AppDataManagerMapper appDataManagerMapper;
    @Test
    public void insertTest(){
        for (int i = 0; i < 50; i++) {
            AppDataManager appDataManager = new AppDataManager();
            if (i%2==0){
                appDataManager.setDataOne("我是数据"+i);
            }else {
                appDataManager.setDataOne("kkka"+i);
            }
            if (i%3==0){
                appDataManager.setDataTwo("我是数据i%3"+i);
            }else {
                appDataManager.setDataTwo("llll%3"+i);
            }
            appDataManager.setDataThree("aldh");
            appDataManager.setDataFour("data4");
            appDataManager.setDataFive("datalllll5");
            appDataManager.setDataSix("asgduad6");
            appDataManager.setDataSeven("apppp7");
            appDataManager.setDataEight(";ewjiwj");
            appDataManager.setDataNine("eight888");
            appDataManager.setDataTen("101000");

            appDataManagerMapper.insertSelective(appDataManager);

        }
    }


    @After

    public void after() {
        System.out.println("测试结束-----------------");

    }

}
