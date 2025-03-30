package com.comefan.taggoodsweb.controller;

import com.comefan.taggoodsweb.entity.TagEntity;
import com.comefan.taggoodsweb.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    private TagService tagService;
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
}
