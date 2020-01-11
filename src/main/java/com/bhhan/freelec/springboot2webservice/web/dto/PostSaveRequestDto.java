package com.bhhan.freelec.springboot2webservice.web.dto;

import com.bhhan.freelec.springboot2webservice.domain.posts.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
