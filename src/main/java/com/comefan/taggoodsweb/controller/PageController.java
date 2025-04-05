package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.entity.GoodsEntity;
import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.entity.TagMarkEntity;
import com.comefan.taggoodsweb.service.GoodsService;
import com.comefan.taggoodsweb.service.TagMarkService;
import com.comefan.taggoodsweb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PageController {

    @Autowired
    private TagService tagService;

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private TagMarkService tagMarkService;

    @RequestMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "comefan");
        return "test/test";
    }

    @RequestMapping("/")
    public String main(){
        return "main/main";
    }

    @RequestMapping("/tag/tagList")
    public String tagList(){
        return "tag/tagList";
    }

    @RequestMapping("/tag/tagAdd")
    public String tagAdd(){
        return "tag/tagAdd";
    }

    @RequestMapping("/tag/tagUpdate/{id}")
    public String tagUpdate(@PathVariable Long id, Model model){
        TagEntity tagEntity = tagService.queryTagById(id);
        model.addAttribute("tag",tagEntity);
        return "tag/tagUpdate";
    }

    @RequestMapping("/goods/goodsList")
    public String goodsList(){
        return "goods/goodsList";
    }

    @RequestMapping("/goods/goodsAdd")
    public String goodsAdd(){
        return "goods/goodsAdd";
    }

    @RequestMapping("/goods/goodsUpdate/{id}")
    public String goodsUpdate(@PathVariable long id, Model model){
        GoodsEntity goodsEntity =  goodsService.queryGoodsById(id);
        model.addAttribute("goods", goodsEntity);
        return "goods/goodsUpdate";
    }

    @RequestMapping("/goods/goodsTag/{id}")
    public String goodsTag(@PathVariable long id,Model model){
        model.addAttribute("goodsId",id);
        List<TagMarkEntity> tagMarkEntities = tagMarkService.queryTagMarkByGoodsId(id);
        List<Long> tagIdList = tagMarkEntities.stream().map(TagMarkEntity::getTagId).collect(Collectors.toList());
        model.addAttribute("tagIdList",tagIdList);
        return "goods/goodsTag";
    }

    @RequestMapping("/goods/goodsDetail")
    public String goodsDetail(){
        return "goods/goodsDetail";
    }
}
