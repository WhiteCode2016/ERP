package com.white.service.admin.domain;

import com.white.common.enums.CommonEnums;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * 用户基本信息类
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@Entity
@Table(name = "B_SYS_USER")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseDomain {
    /** 用户ID **/
    @Id
    @Column(name = "USER_ID", length = 32)
    private String userId;
    /** 用户名 **/
    @Column(name = "USER_NAME", length = 32)
    private String userName;
    /** 用户密码 **/
    @Column(name = "PASSWORD", length = 64)
    private String password;
    /** 手机号 **/
    @Column(name = "PHONE", length = 16)
    private String phone;
    /** 邮箱 **/
    @Column(name = "EMAIL", length = 32)
    private String email;
    /** 用户状态 **/
    @Column(name = "USER_STATUS")
    @Enumerated(EnumType.STRING)
    private CommonEnums.StatusEnum userStatus;
}
