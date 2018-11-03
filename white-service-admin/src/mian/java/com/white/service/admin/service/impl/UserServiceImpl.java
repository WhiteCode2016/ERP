package com.white.service.admin.service.impl;

import com.github.pagehelper.ISelect;
import com.white.common.dto.BaseResultDTO;
import com.white.common.dto.OrderAblePaginationDTO;
import com.white.common.dto.PaginationResultDTO;
import com.white.service.admin.domain.User;
import com.white.service.admin.dto.UserDTO;
import com.white.service.admin.dto.UserQueryDTO;
import com.white.service.admin.mapper.UserMapper;
import com.white.service.admin.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserMapper> implements UserService {

    @Override
    public BaseResultDTO<PaginationResultDTO<UserDTO>> findPlusByPagination(int pageNum, int pageSize, UserQueryDTO queryDTO) {
        OrderAblePaginationDTO orderAblePaginationDTO = new OrderAblePaginationDTO(pageNum, pageSize);
        List<UserDTO> list = this.executeQuery(orderAblePaginationDTO, new ISelect() {
            @Override
            public void doSelect() {
                dao.findByCondition(queryDTO);
            }
        });
        return BaseResultDTO.success(new PaginationResultDTO<UserDTO>(orderAblePaginationDTO, list));
    }

    @Override
    public PaginationResultDTO<UserDTO> findByPagination(int pageNum, int pageSize, UserQueryDTO queryDTO) {
        OrderAblePaginationDTO orderAblePaginationDTO = new OrderAblePaginationDTO(pageNum, pageSize);
        List<UserDTO> list = this.executeQuery(orderAblePaginationDTO, new ISelect() {
            @Override
            public void doSelect() {
                dao.findByCondition(queryDTO);
            }
        });
        return new PaginationResultDTO<UserDTO>(orderAblePaginationDTO, list);
    }
}
