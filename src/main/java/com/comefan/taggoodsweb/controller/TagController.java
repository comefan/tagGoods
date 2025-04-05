package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.common.enums.TagStatusEnum;
import com.comefan.taggoodsweb.common.spect.annotation.AutoFillDefaultValue;
import com.comefan.taggoodsweb.controller.vo.BaseResponse;
import com.comefan.taggoodsweb.controller.vo.TagVO;
import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.service.TagMarkService;
import com.comefan.taggoodsweb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private TagMarkService tagMarkService;

    @GetMapping("/tag")
    public BaseResponse<List<TagVO>> queryuTagList(Long tagId, String tagName){
        BaseResponse<List<TagVO>> successResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        List<TagEntity> tagEntities = tagService.queryTagList(tagId, tagName);
        List<TagVO> tagVos = tagEntities.stream().map(TagVO::transferEntityToVO).collect(Collectors.toList());
        successResponse.setData(tagVos);
        return successResponse;
    }
    @AutoFillDefaultValue()
    @PostMapping("/tag")
    public BaseResponse insert(@RequestBody TagEntity tagEntity){
        BaseResponse baseResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        tagEntity.setStatus(TagStatusEnum.USE.getCode());
        tagService.insert(tagEntity);
        return baseResponse;
    }

    @PutMapping("/tag")
    public BaseResponse update(@RequestBody TagEntity tagEntity){
        BaseResponse baseResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        tagService.update(tagEntity);
        return baseResponse;
    }

    @DeleteMapping("/tag/{id}")
    public BaseResponse delete(@PathVariable Long id){
        TagEntity tagEntity = tagService.queryTagById(id);
        if(tagEntity == null){
            return BaseResponse.getFailResponse(BaseResponse.class, "标签不存在");
        }
        tagEntity.setStatus(TagStatusEnum.DELETE.getCode());
        tagService.update(tagEntity);
        if(tagEntity.getCleanOnDelete() == 0){
            tagMarkService.deleteTagMarkByTagId(tagEntity.getId());
        }

        return BaseResponse.getSuccessResponse(BaseResponse.class);
    }
}
