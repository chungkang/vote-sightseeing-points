package com.chungkang.webservice.web;

import com.chungkang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/map")
    public String map(Model model) {
        return "map";
    }

    @GetMapping("/lists")
    public String lists(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "lists";
    }

    @GetMapping("/details")
    public String details(Model model) {
        return "details";
    }

    @GetMapping("/add")
    public String add(Model model) {
        return "add";
    }
}