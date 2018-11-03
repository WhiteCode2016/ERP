package com.white.service.admin.tk;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * MyBatis基础接口
 *
 * @Author: White
 * @Date: 2018/11/2
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
