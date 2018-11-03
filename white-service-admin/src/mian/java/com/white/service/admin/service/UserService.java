package com.white.service.admin.service;

import com.white.common.dto.BaseResultDTO;
import com.white.common.dto.PaginationResultDTO;
import com.white.service.admin.domain.User;
import com.white.service.admin.dto.UserDTO;
import com.white.service.admin.dto.UserQueryDTO;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
public interface UserService extends BaseService<User> {

    /**
     * 按条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @param queryDTO
     * @return
     */
    BaseResultDTO<PaginationResultDTO<UserDTO>> findPlusByPagination(int pageNum, int pageSize, UserQueryDTO queryDTO);

    /**
     * 按条件分页查询
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @param queryDTO
     * @return
     */
    PaginationResultDTO<UserDTO> findByPagination(int pageNum, int pageSize, UserQueryDTO queryDTO);
}
