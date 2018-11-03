package com.white.web.admin.service.fallback;

import com.white.common.hystrix.Fallback;
import com.white.web.admin.service.UserService;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/3
 */
@Component
public class UserServiceFallback implements UserService {
    @Override
    public String page(int pageNum, int pageSize, String tbSysUserJson) {
        return Fallback.badGateway();
    }
}
