package com.comefan.taggoodsweb.mapper;

import com.comefan.taggoodsweb.entity.TagMarkEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TagMarkMapper {

    /**
     * 插入标记
     */
    Integer insert(TagMarkEntity tagMarkEntity);

    List<TagMarkEntity> queryTagMarkByGoods(Long goodsId);

    Integer deleteByGoodsId(Long goodsId);

    Integer deleteByTagId(Long tagId);
}
