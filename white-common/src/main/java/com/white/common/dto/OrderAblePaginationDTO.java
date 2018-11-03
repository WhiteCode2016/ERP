package com.white.common.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 接受前端分页信息
 *
 * @author: White
 * @date: 2018/6/8
 */
@Data
public class OrderAblePaginationDTO implements Serializable {
    /** 当前页码 **/
    private int pageNum;
    /** 每页记录数 **/
    private Integer pageSize;
    /** 总记录数 **/
    private Integer totalCount;

    public OrderAblePaginationDTO() {
        this(1, Integer.MAX_VALUE);
    }

    public OrderAblePaginationDTO(int pageNum,int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
}
