package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.common.enums.TagStatusEnum;
import com.comefan.taggoodsweb.controller.vo.BaseResponse;
import com.comefan.taggoodsweb.controller.vo.TagVO;
import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public BaseResponse<List<TagVO>> queryuTagList(Long tagId, String tagName){
        BaseResponse<List<TagVO>> successResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        List<TagEntity> tagEntities = tagService.queryTagList(tagId, tagName);
        List<TagVO> tagVos = tagEntities.stream().map(TagVO::transferEntityToVO).collect(Collectors.toList());
        successResponse.setData(tagVos);
        return successResponse;
    }

    @PostMapping("/tag")
    public BaseResponse insert(@RequestBody TagEntity tagEntity){
        BaseResponse baseResponse = BaseResponse.getSuccessResponse(BaseResponse.class);
        tagEntity.setStatus(TagStatusEnum.USE.getCode());
        tagService.insert(tagEntity);
        return baseResponse;
    }
}
