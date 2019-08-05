package com.chungkang.webservice.web;

import com.chungkang.webservice.dto.points.PointsMainResponseDto;
import com.chungkang.webservice.dto.points.PointsSaveRequestDto;
import com.chungkang.webservice.dto.posts.PostsSaveRequestDto;
import com.chungkang.webservice.service.PointsService;
import com.chungkang.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private PointsService pointsService;
    private Environment env;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .filter(e -> "set1".equals(e) || "set2".equals(e) || "local".equals(e))
                .findFirst()
                .orElse("");
    }

    @PostMapping("/add")
    public Long savePoints(@RequestBody PointsSaveRequestDto dto) { return pointsService.save(dto); }
}
