package com.comefan.taggoodsweb.controller.vo;

import com.comefan.taggoodsweb.entity.TagEntity;
import lombok.Data;

import java.util.Date;

@Data
public class TagVO extends BaseVO {
    private Long id;
    private String name;
    private String description;
    private Integer status;
    private String style;
    private Date expireTime;
    private Integer cleanOnDelete;
    private Integer cleanOnExpire;

    public static TagVO transferEntityToVO(TagEntity tagEntity) {
        TagVO tagVO = new TagVO();
        tagVO.setId(tagEntity.getId());
        tagVO.setName(tagEntity.getName());
        tagVO.setDescription(tagEntity.getDescription());
        tagVO.setStatus(tagEntity.getStatus());
        tagVO.setStyle(tagEntity.getStyle());
        tagVO.setExpireTime(tagEntity.getExpireTime());
        tagVO.setCleanOnDelete(tagEntity.getCleanOnDelete());
        tagVO.setCleanOnExpire(tagEntity.getCleanOnExpire());
        tagVO.setCreator(tagEntity.getCreator());
        tagVO.setCreateTime(tagEntity.getCreateTime());
        tagVO.setModifier(tagEntity.getModifier());
        tagVO.setModifyTime(tagEntity.getModifyTime());
        return tagVO;
    }
}
