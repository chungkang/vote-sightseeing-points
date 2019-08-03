package com.chungkang.webservice.web;

import com.chungkang.webservice.dto.posts.PostsSaveRequestDto;
import com.chungkang.webservice.dto.users.UsersSaveRequestDto;
import com.chungkang.webservice.service.PostsService;
import com.chungkang.webservice.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private UsersService usersService;
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

    @GetMapping("/users/signup")
    public void signupGET() {

    }

    @PostMapping("/users/signup")
    public Long signupPOST(@RequestBody UsersSaveRequestDto dto) {
        return usersService.save(dto);
    }
}
