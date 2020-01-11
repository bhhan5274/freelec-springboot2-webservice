package com.bhhan.freelec.springboot2webservice.web.dto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        String name = "test";
        int amount = 1000;

        final HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}