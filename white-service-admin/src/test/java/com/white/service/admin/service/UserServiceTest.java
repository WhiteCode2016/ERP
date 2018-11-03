package com.white.service.admin.service;

import com.white.service.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectOne() {
        User user = new User();
        user.setUserId("1");
        log.info(userService.selectOne(user).toString());
    }
}