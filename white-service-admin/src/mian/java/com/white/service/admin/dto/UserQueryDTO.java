package com.white.service.admin.dto;

import com.white.common.enums.CommonEnums;
import lombok.Data;

/**
 * All rights Reserved, Designed by xxxx
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@Data
public class UserQueryDTO {
    private String userName;
    private CommonEnums.StatusEnum userStatus;
}
