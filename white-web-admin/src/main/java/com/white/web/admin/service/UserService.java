package com.white.web.admin.service;

import com.white.web.admin.service.fallback.UserServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/3
 */
@FeignClient(value = "white-service-admin", fallback = UserServiceFallback.class)
public interface UserService {
    /**
     * 分页查询
     *
     * @param pageNum
     * @param pageSize
     * @param userQueryDTOJsonStr
     * @return
     */
    @RequestMapping(value = "v1/system/user/page/{pageNum}/{pageSize}", method = RequestMethod.POST)
    String page(@PathVariable(value = "pageNum") int pageNum,
                @PathVariable(value = "pageSize") int pageSize,
                @RequestParam(value = "userQueryDTOJsonStr", required = false) String userQueryDTOJsonStr);
}
