package com.bhhan.freelec.springboot2webservice.web;

import com.bhhan.freelec.springboot2webservice.config.auth.LoginUser;
import com.bhhan.freelec.springboot2webservice.config.auth.dto.SessionUser;
import com.bhhan.freelec.springboot2webservice.service.PostService;
import com.bhhan.freelec.springboot2webservice.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

/**
 * Created by hbh5274@gmail.com on 2020-01-12
 * Github : http://github.com/bhhan5274
 */

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostService postService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts", postService.findAllDesc());

        if(user != null){
            model.addAttribute("loginName", user.getName());
        }

        return "index";
    }

    @GetMapping("/post/save")
    public String postSave(){
        return "post-save";
    }

    @GetMapping("/post/update/{id}")
    public String postUpdate(@PathVariable Long id, Model model){
        final PostResponseDto dto = postService.findById(id);
        model.addAttribute("post", dto);

        return "post-update";
    }
}
