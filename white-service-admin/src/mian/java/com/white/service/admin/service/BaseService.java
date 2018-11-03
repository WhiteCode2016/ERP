package com.white.service.admin.service;

import com.github.pagehelper.PageInfo;
import com.white.service.admin.domain.BaseDomain;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
public interface BaseService<T extends BaseDomain> {
    /**
     * 添加
     * @param t
     * @param createBy 创建人Id
     * @return
     */
    int insert(T t, Long createBy);

    /**
     * 更新
     * @param t
     * @param lastModifiedBy 修改人Id
     * @return
     */
    int update(T t, Long lastModifiedBy);

    /**
     * 删除
     * @param t
     * @return
     */
    int delete(T t);

    /**
     * 统计
     * @param t
     * @return
     */
    int count(T t);

    /**
     * 查询
     * @param t
     * @return
     */
    T selectOne(T t);

    /**
     * 分页
     * @param pageNum 当前页码
     * @param pageSize 每页记录数
     * @param t
     * @return
     */
    PageInfo<T> page(int pageNum, int pageSize, T t);
}
