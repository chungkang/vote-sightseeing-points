package com.chungkang.webservice.web;

import com.chungkang.webservice.service.PointsService;
import com.chungkang.webservice.service.PostsService;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
        model.addAttribute("pointsJSON", new Gson().toJson(pointsService.findByPermit()));
        return "map";
    }

    @GetMapping("/lists")
    public String lists(Model model) {
        model.addAttribute("points", pointsService.findByPermit());
        model.addAttribute("count", pointsService.countPermit());
        return "lists";
    }

    @GetMapping("/detail/{point_no}")
    public String details(Model model, @PathVariable Long point_no) {
        model.addAttribute("point", pointsService.findOne(point_no));
        model.addAttribute("pointJSON", new Gson().toJson(pointsService.findOne(point_no)));
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