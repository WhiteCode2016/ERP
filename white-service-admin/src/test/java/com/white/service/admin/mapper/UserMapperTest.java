package com.white.service.admin.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void getUser() {
        log.info(userMapper.selectAll().toString());
    }
}
