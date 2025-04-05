package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.common.spect.annotation.AutoFillDefaultValue;
import com.comefan.taggoodsweb.controller.param.TagGoodsParam;
import com.comefan.taggoodsweb.controller.vo.BaseResponse;
import com.comefan.taggoodsweb.controller.vo.GoodsVO;
import com.comefan.taggoodsweb.entity.GoodsEntity;
import com.comefan.taggoodsweb.entity.TagMarkEntity;
import com.comefan.taggoodsweb.service.GoodsService;
import com.comefan.taggoodsweb.service.TagMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TagMarkService tagMarkService;

    @GetMapping("/goods")
    public BaseResponse getGoods(Long goodsId, String goodsName){
        BaseResponse<List<GoodsVO>> baseResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        List<GoodsEntity> goodsEntities = goodsService.queryGoodsList(goodsId, goodsName);
        List<GoodsVO> goodsVOS = goodsEntities.stream().map(GoodsVO::entityToVO).collect(Collectors.toList());
        baseResponse.setData(goodsVOS);
        return baseResponse;
    }

    @PostMapping("/goods")
    @AutoFillDefaultValue
    public BaseResponse addGoods(@RequestBody GoodsEntity goodsEntity){
        goodsService.insertGoods(goodsEntity);
        return BaseResponse.getSuccessResponse(BaseResponse.class);
    }

    @PutMapping("/goods")
    public BaseResponse updateGoods(@RequestBody GoodsEntity goodsEntity){
        goodsService.updateGoods(goodsEntity);
        return BaseResponse.getSuccessResponse(BaseResponse.class);
    }

    @DeleteMapping("/goods/{id}")
    public BaseResponse deleteGoods(@PathVariable("id") Long id){
        goodsService.deleteGoods(id);
        return BaseResponse.getSuccessResponse(BaseResponse.class);
    }

    @PostMapping("/tagGoods")
    @AutoFillDefaultValue
    public BaseResponse tagGoods(@RequestBody TagGoodsParam tagGoodsParam){
        tagMarkService.deleteTagMarkByGoodsId(tagGoodsParam.getGoodsId());
        tagGoodsParam.getTagIdList().forEach(tagId ->{
            TagMarkEntity tagMarkEntity = new TagMarkEntity();
            tagMarkEntity.setGoodsId(tagGoodsParam.getGoodsId());
            tagMarkEntity.setTagId(tagId);
            tagMarkEntity.setCreator(tagGoodsParam.getCreator());
            tagMarkEntity.setModifier(tagGoodsParam.getModifier());
            tagMarkEntity.setCreateTime(tagGoodsParam.getCreateTime());
            tagMarkEntity.setModifyTime(tagGoodsParam.getModifyTime());
            tagMarkService.insert(tagMarkEntity);
        });
        return BaseResponse.getSuccessResponse(BaseResponse.class);
    }

}
