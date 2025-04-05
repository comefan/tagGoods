package com.comefan.taggoodsweb.mapper;

import com.comefan.taggoodsweb.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {
    List<GoodsEntity> queryGoodsList(@Param("id") Long id,@Param("name") String name);

    Integer insert(GoodsEntity goodsEntity);

    Integer update(GoodsEntity goodsEntity);

    GoodsEntity queryGoodsById(Long id);

    Integer delete(Long id);
}
