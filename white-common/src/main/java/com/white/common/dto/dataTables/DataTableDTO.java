package com.white.common.dto.dataTables;

import com.white.common.dto.PaginationResultDTO;
import lombok.Data;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/3
 */
@Data
public class DataTableDTO<T> {
    /** 没有过滤的记录数 **/
    private Integer recordsTotal;
    /** 过滤后的记录数 **/
    private Integer recordsFiltered;
    /** 数据 **/
    private T data;

    public DataTableDTO() {
    }

    public DataTableDTO(PaginationResultDTO<T> paginationResultDTO) {
        if (paginationResultDTO != null) {
            setRecordsFiltered(paginationResultDTO.getTotalCount());
            setRecordsTotal(paginationResultDTO.getTotalCount());
            setData(paginationResultDTO.getData());
        }
    }
}
