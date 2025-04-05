package com.comefan.taggoodsweb.controller.vo;

import com.comefan.taggoodsweb.entity.GoodsEntity;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class GoodsVO extends BaseVO{
    private Long id;

    private String name;

    private Double price;

    private String description;

    private String img;

    private List<TagVO> tagList;

    public static GoodsVO entityToVO(GoodsEntity entity){
        GoodsVO vo = new GoodsVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setPrice(entity.getPrice());
        vo.setDescription(entity.getDescription());
        vo.setImg(entity.getImg());
        if(!CollectionUtils.isEmpty(entity.getTagEntityList())){
            vo.setTagList(entity.getTagEntityList().stream().map(TagVO::transferEntityToVO).collect(Collectors.toList()));
        }

        vo.setCreateTime(entity.getCreateTime());
        vo.setCreator(entity.getCreator());
        vo.setModifier(entity.getModifier());
        vo.setModifyTime(entity.getModifyTime());
        return vo;
    }
}
