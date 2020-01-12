package com.bhhan.freelec.springboot2webservice.web.dto;

import com.bhhan.freelec.springboot2webservice.domain.posts.Post;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * Created by hbh5274@gmail.com on 2020-01-12
 * Github : http://github.com/bhhan5274
 */

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PostListResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.modifiedDate = post.getModifiedDate();
    }
}
