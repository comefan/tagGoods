package com.comefan.taggoodsweb.service;

import com.comefan.taggoodsweb.common.constant.CommonConstant;
import com.comefan.taggoodsweb.entity.GoodsEntity;
import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.entity.TagMarkEntity;
import com.comefan.taggoodsweb.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private TagMarkService tagMarkService;

    @Autowired
    private TagService tagService;

    public List<GoodsEntity> queryGoodsList(Long id,String name){
        List<GoodsEntity> goodsEntities = goodsMapper.queryGoodsList(id, name);
        if(CollectionUtils.isEmpty(goodsEntities)){
            return new ArrayList<>();
        }
        goodsEntities.forEach(goodsEntity -> {
            List<TagMarkEntity> tagMarkEntities = tagMarkService.queryTagMarkByGoodsId(goodsEntity.getId());
            if(!CollectionUtils.isEmpty(tagMarkEntities)){
                List<Long> tagIdList = tagMarkEntities.stream().map(TagMarkEntity::getTagId).collect(Collectors.toList());
                List<TagEntity> tagEntities = tagService.queryTagByIds(tagIdList);
                goodsEntity.setTagEntityList(tagEntities);
            }
        } );
        return goodsEntities;
    }

    public Integer insertGoods(GoodsEntity goodsEntity){
        Integer result = goodsMapper.insert(goodsEntity);
        insertTagMark(goodsEntity);
        return result;
    }

    public void insertTagMark(GoodsEntity goodsEntity){
        TagMarkEntity tagMarkEntity = new TagMarkEntity();
        tagMarkEntity.setGoodsId(goodsEntity.getId());
        tagMarkEntity.setTagId(CommonConstant.NEW_SHOP_TAG_ID);
        tagMarkEntity.setCreator(goodsEntity.getCreator());
        tagMarkEntity.setCreateTime(goodsEntity.getCreateTime());
        tagMarkEntity.setModifyTime(goodsEntity.getModifyTime());
        tagMarkEntity.setModifier(goodsEntity.getModifier());
        tagMarkService.insert(tagMarkEntity);
    }

    public Integer updateGoods(GoodsEntity goodsEntity){
        return goodsMapper.update(goodsEntity);
    }

    public GoodsEntity queryGoodsById(Long id){
        return goodsMapper.queryGoodsById(id);
    }

    public Integer deleteGoods(Long id){
        return goodsMapper.delete(id);
    }

}
