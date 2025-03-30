package com.comefan.taggoodsweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
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
}
