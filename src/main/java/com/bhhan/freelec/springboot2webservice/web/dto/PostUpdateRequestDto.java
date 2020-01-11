package com.bhhan.freelec.springboot2webservice.web.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@Getter
public class PostUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }
}
