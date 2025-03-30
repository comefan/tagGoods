package com.comefan.taggoodsweb.entity;

import lombok.Data;

@Data
public class GoodsEntity extends BaseEntity{
    private Long id;

    private String name;

    private Double price;

    private String description;

    private String img;

}
