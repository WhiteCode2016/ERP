package com.white.common.dto;

import com.white.common.enums.CommonEnums;
import lombok.Data;

import java.io.Serializable;

/**
 * 所有RestFul接口返回的结果集
 *
 * @author: White
 * @date: 2018/6/1
 */
@Data
public class BaseResultDTO<T> implements Serializable {
    private static final String SUCCESS = "SUCCESS";
    private static final String FAILURE = "FAILURE";
    /** 状态 **/
    private String status;
    /** 返回代码 **/
    private Integer code;
    /** 返回信息 **/
    private String message;
    /** 数据 **/
    private T result;

    public static <T> BaseResultDTO<T> reject(Integer code, String message) {
        return createBaseResultDTO(FAILURE, code, message, null);
    }

    public static <T> BaseResultDTO<T> reject() {
        return reject(CommonEnums.ResultEnum.FAILURE.getCode(),CommonEnums.ResultEnum.FAILURE.getMessage());
    }

    public static <T> BaseResultDTO<T> success(Integer code, String message, T result) {
        return createBaseResultDTO(SUCCESS, code, message, result);
    }

    public static <T> BaseResultDTO<T> success(T result) {
        return success(CommonEnums.ResultEnum.SUCCESS.getCode(), CommonEnums.ResultEnum.SUCCESS.getMessage(), result);
    }

    public static <T> BaseResultDTO<T> success() {
        return success(CommonEnums.ResultEnum.SUCCESS.getCode(), CommonEnums.ResultEnum.SUCCESS.getMessage(), null);
    }

    private static <T> BaseResultDTO<T> createBaseResultDTO(String status, Integer code, String message, T result) {
        BaseResultDTO<T> baseResultDTO = new BaseResultDTO<T>();
        baseResultDTO.setStatus(status);
        baseResultDTO.setCode(code);
        baseResultDTO.setMessage(message);
        baseResultDTO.setResult(result);
        return baseResultDTO;
    }
}

