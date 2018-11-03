package com.white.service.admin.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Domain基础数据类
 *
 * @Author: White
 * @Date: 2018/11/2
 */
@Data
public class BaseDomain implements Serializable {
    /** 创建人 **/
    @Column(name = "CREATE_BY")
    private Long createBy;

    /** 创建时间 **/
    @Column(name = "CREATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /** 修改人 **/
    @Column(name = "LAST_MODIFIED_BY")
    private Long lastModifiedBy;

    /** 修改时间 **/
    @Column(name = "LAST_MODIFIED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedTime;
}
