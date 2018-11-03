package com.white.service.admin.service.impl;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.white.common.dto.OrderAblePaginationDTO;

import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @author: White
 * @date: 2018/6/8
 */
public abstract class AbstractServiceImpl {

    protected <E> List<E> executeQuery(OrderAblePaginationDTO orderAblePaginationDTO, ISelect select) {
        /*if (op.getOrders() != null) {
            Iterator var = op.getOrders().iterator();
            while (var.hasNext()) {
                OrderDTO orderDTO = (OrderDTO) var.next();
                PageHelper.orderBy(String.format("%s %s", orderDTO.getPropertyName(), orderDTO.isDesc() ? "desc" : "asc"));
            }
        }*/
        Page<E> page = PageHelper.startPage(orderAblePaginationDTO.getPageNum(), orderAblePaginationDTO.getPageSize()).doSelectPage(select);
        orderAblePaginationDTO.setTotalCount((int) page.getTotal());
        return page.getResult();
    }
   protected <E> List<E> executeQuery(int pageNum, int pageSize, ISelect select) {
       Page<E> page = PageHelper.startPage(pageNum, pageSize).doSelectPage(select);
       return page.getResult();
   }
}
