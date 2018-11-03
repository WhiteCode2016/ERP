package com.white.service.admin.controller;

import com.white.common.dto.BaseResultDTO;
import com.white.common.dto.PaginationResultDTO;
import com.white.common.utils.MapperUtils;
import com.white.service.admin.dto.UserDTO;
import com.white.service.admin.dto.UserQueryDTO;
import com.white.service.admin.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@RestController
@RequestMapping(value = "v1/system/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 分页查询
     *
     * @param pageNum             当前页码
     * @param pageSize            每页记录数
     * @param userQueryDTOJsonStr
     * @return
     */
    @RequestMapping(value = "page/{pageNum}/{pageSize}", method = {RequestMethod.GET, RequestMethod.POST})
    public PaginationResultDTO<UserDTO> page(@PathVariable int pageNum, @PathVariable int pageSize, @RequestParam(required = false) String userQueryDTOJsonStr) {
        UserQueryDTO userQueryDTO = null;
        if (StringUtils.isNotBlank(userQueryDTOJsonStr)) {
            try {
                // 将传过来的JSON字符串转化成UserQuerDTO对象
                userQueryDTO = MapperUtils.json2pojo(userQueryDTOJsonStr, UserQueryDTO.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return userService.findByPagination(pageNum, pageSize, userQueryDTO);
    }
}
