package com.comefan.taggoodsweb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {
    private Integer creator;
    private Integer modifier;
    private Date createTime;
    private Date modifyTime;
}
