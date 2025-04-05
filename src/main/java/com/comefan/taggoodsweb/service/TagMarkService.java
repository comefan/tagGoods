package com.comefan.taggoodsweb.service;

import com.comefan.taggoodsweb.entity.TagMarkEntity;
import com.comefan.taggoodsweb.mapper.TagMarkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagMarkService {
    @Autowired
    private TagMarkMapper tagMarkMapper;

    public Integer insert(TagMarkEntity tagMarkEntity){
        return tagMarkMapper.insert(tagMarkEntity);
    }

    public List<TagMarkEntity> queryTagMarkByGoodsId(Long goodsId){
        return tagMarkMapper.queryTagMarkByGoods(goodsId);
    }

    public Integer deleteTagMarkByGoodsId(Long goodsId){
        return tagMarkMapper.deleteByGoodsId(goodsId);
    }

    public Integer deleteTagMarkByTagId(Long tagId){
        return tagMarkMapper.deleteByTagId(tagId);
    }
}
