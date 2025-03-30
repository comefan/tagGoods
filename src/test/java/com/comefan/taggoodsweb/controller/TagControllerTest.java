package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.controller.vo.BaseResponse;
import com.comefan.taggoodsweb.controller.vo.TagVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class TagControllerTest {

    @Autowired
    private TagController tagController;
    @Test
    public void testQueryTaglist() {
        BaseResponse<List<TagVO>> listBaseResponse = tagController.queryuTagList(null, null);
        Assert.isTrue(listBaseResponse.getCode().equals(0));
    }
}
