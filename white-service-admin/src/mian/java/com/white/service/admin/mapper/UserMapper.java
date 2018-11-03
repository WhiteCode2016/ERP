package com.white.service.admin.mapper;

import com.white.service.admin.domain.User;
import com.white.service.admin.dto.UserDTO;
import com.white.service.admin.dto.UserQueryDTO;
import com.white.service.admin.tk.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@Repository
public interface UserMapper extends MyMapper<User> {
    /**
     * 条件查询
     * @param queryDTO
     * @return
     */
    List<UserDTO> findByCondition(UserQueryDTO queryDTO);
}
