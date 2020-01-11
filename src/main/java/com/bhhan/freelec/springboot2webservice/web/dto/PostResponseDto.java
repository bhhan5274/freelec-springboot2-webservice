package com.bhhan.freelec.springboot2webservice.web.dto;

import com.bhhan.freelec.springboot2webservice.domain.posts.Post;
import lombok.Getter;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
