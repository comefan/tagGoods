package com.comefan.taggoodsweb.entity;

import lombok.Data;

@Data
public class TagMarkEntity extends BaseEntity {

    private Long id;

    private Long goodsId;

    private Long tagId;
}
