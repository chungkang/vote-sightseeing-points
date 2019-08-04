package com.chungkang.webservice.web;

import com.chungkang.webservice.service.PointsService;
import com.chungkang.webservice.service.PostsService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;
    private PointsService pointsService;

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/map")
    public String map(Model model) {
        model.addAttribute("pointsJSON", new Gson().toJson(pointsService.findAllPoints()));
        System.out.println(new Gson().toJson(pointsService.findAllPoints()));
        return "map";
    }

    @GetMapping("/lists")
    public String lists(Model model) {
        return "lists";
    }

    @GetMapping("/detail")
    public String details(Model model) {

        return "detail";
    }

    @GetMapping("/add")
    public String add(Model model) { return "add"; }

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("points", pointsService.findAllPoints());
        return "admin";
    }
}