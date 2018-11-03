package com.white.common.enums;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
public class CommonEnums {

    /** 状态 **/
    public enum StatusEnum {
        // 正常 **/
        NORMAL,
        /** 禁用 **/
        FORBIDDEN
    }

    /** 权限类型 **/
    public enum PermissionTypeEnum {
        /** 按钮 **/
        BUTTON,
        /** 菜单 **/
        MENU
    }

    /** 返回结果集的Enum **/
    public enum ResultEnum {
        /** 通用成功 **/
        SUCCESS(1000,"成功"),
        /** 通用失败 **/
        FAILURE(10001,"失败"),
        /** 502 **/
        BAD_GATEWAY(502, "从上游服务器接收到无效的响应");

        private Integer code;
        private String message;

        ResultEnum(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
