package com.bhhan.freelec.springboot2webservice.web;

import com.bhhan.freelec.springboot2webservice.common.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hbh5274@gmail.com on 2020-02-16
 * Github : http://github.com/bhhan5274
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProfileControllerTest extends BaseTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("profile은 인증없이 호출된다.")
    public void profile_test1(){
        final ResponseEntity<String> response = testRestTemplate.getForEntity("/profile", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotBlank();
    }
}