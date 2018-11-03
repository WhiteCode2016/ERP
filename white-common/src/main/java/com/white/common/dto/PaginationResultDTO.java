package com.white.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果集
 *
 * @Author: White
 * @Date: 2018/11/3
 */
@Data
public class PaginationResultDTO<T> implements Serializable {
    /** 当前页码 **/
    private Integer pageNum;
    /** 每页记录数 **/
    private Integer pageSize;
    /** 总记录数 **/
    private Integer totalCount;
    /** 分页数据 **/
    private T data;

    public PaginationResultDTO(OrderAblePaginationDTO orderAblePaginationDTO, List<T> data) {
        setData((T) data);
        if (orderAblePaginationDTO != null) {
            setPageNum(orderAblePaginationDTO.getPageNum());
            setPageSize(orderAblePaginationDTO.getPageSize());
            setTotalCount(orderAblePaginationDTO.getTotalCount());
        } else {
            setTotalCount(0);
        }
    }
}
