package com.white.service.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.white.service.admin.domain.BaseDomain;
import com.white.service.admin.service.BaseService;
import com.white.service.admin.tk.MyMapper;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
public class BaseServiceImpl<T extends BaseDomain,D extends MyMapper<T>> extends AbstractServiceImpl implements BaseService<T> {

    @Resource
    protected D dao;

    @Override
    public int insert(T t, Long createBy) {
        t.setCreateBy(createBy);
        t.setCreateTime(new Date());
        t.setLastModifiedBy(createBy);
        t.setLastModifiedTime(new Date());
        return dao.insert(t);
    }

    @Override
    public int update(T t, Long lastModifiedBy) {
        t.setLastModifiedBy(lastModifiedBy);
        t.setLastModifiedTime(new Date());
        return dao.updateByPrimaryKey(t);
    }

    @Override
    public int delete(T t) {
        return dao.delete(t);
    }

    @Override
    public int count(T t) {
        return dao.selectCount(t);
    }

    @Override
    public T selectOne(T t) {
        return dao.selectOne(t);
    }

    @Override
    public PageInfo<T> page(int pageNum, int pageSize, T t) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list = dao.select(t);
        return new PageInfo<>(list);
    }
}
