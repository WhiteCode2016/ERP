package com.white.common.hystrix;

import com.google.common.collect.Lists;
import com.white.common.dto.BaseResultDTO;
import com.white.common.enums.CommonEnums;
import com.white.common.utils.MapperUtils;

/**
 * 通用的熔断方法
 *
 * @Author: White
 * @Date: 2018/11/3
 */
public class Fallback {
    public static String badGateway() {
        BaseResultDTO baseResult = BaseResultDTO.reject(CommonEnums.ResultEnum.BAD_GATEWAY.getCode(),
                CommonEnums.ResultEnum.BAD_GATEWAY.getMessage());
        try {
            return MapperUtils.obj2json(baseResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
