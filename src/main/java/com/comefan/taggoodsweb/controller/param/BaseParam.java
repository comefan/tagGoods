package com.comefan.taggoodsweb.controller.param;

import lombok.Data;

import java.util.Date;

@Data
public class BaseParam {
    private Integer creator;
    private Integer modifier;
    private Date createTime;
    private Date modifyTime;
}
