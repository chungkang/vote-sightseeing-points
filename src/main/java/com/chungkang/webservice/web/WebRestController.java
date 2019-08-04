package com.chungkang.webservice.web;

import com.chungkang.webservice.dto.posts.PostsSaveRequestDto;
import com.chungkang.webservice.dto.members.MembersSaveRequestDto;
import com.chungkang.webservice.service.PostsService;
import com.chungkang.webservice.service.MembersService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private MembersService membersService;
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

    @GetMapping("/members/signup")
    public void signupGET() {

    }

    @PostMapping("/members/signup")
    public Long signupPOST(@RequestBody MembersSaveRequestDto dto) {
        return membersService.save(dto);
    }

    @RequestMapping("/members/emailcheck")
    @ResponseBody
    public Map<Object, Object> emailCheck(@RequestBody String email) {
        int count = 0;
        Map<Object, Object> map = new HashMap<Object, Object>();
        count = membersService.emailCheck(email);
        map.put("count", count);
        return map;
    }
}
