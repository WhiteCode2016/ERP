package com.white.web.admin.dto;

import com.white.common.enums.CommonEnums;
import lombok.Data;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/10/31
 */
@Data
public class UserDTO {
    /** 用户ID **/
    private String userId;
    /** 用户名 **/
    private String userName;
    /** 手机号 **/
    private String phone;
    /** 邮箱 **/
    private String email;
    /** 用户状态 **/
    private CommonEnums.StatusEnum userStatus;
}
