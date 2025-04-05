package com.comefan.taggoodsweb.entity;

import lombok.Data;

import java.util.List;

@Data
public class GoodsEntity extends BaseEntity{
    private Long id;

    private String name;

    private Double price;

    private String description;

    private String img;

    private List<TagEntity> tagEntityList;

}
