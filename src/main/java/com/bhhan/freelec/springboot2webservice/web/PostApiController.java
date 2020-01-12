package com.bhhan.freelec.springboot2webservice.web;

import com.bhhan.freelec.springboot2webservice.service.PostService;
import com.bhhan.freelec.springboot2webservice.web.dto.PostResponseDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostSaveRequestDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@RestController
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }

    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto){
        return postService.update(id, requestDto);
    }

    @GetMapping("/api/v1/post/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/post/{id}")
    public Long delete(@PathVariable Long id){
        postService.delete(id);
        return id;
    }
}
