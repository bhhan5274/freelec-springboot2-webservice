package com.bhhan.freelec.springboot2webservice.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@Getter
@RequiredArgsConstructor
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
