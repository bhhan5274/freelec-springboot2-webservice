package com.bhhan.freelec.springboot2webservice.web;

import com.bhhan.freelec.springboot2webservice.domain.posts.Post;
import com.bhhan.freelec.springboot2webservice.domain.posts.PostRepository;
import com.bhhan.freelec.springboot2webservice.web.dto.PostSaveRequestDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void tearDown(){
        postRepository.deleteAll();
    }

    @Test
    public void post_등록된다(){
        String title = "title";
        String content = "content";
        final PostSaveRequestDto requestDto = PostSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/post";

        final ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        final List<Post> all = postRepository.findAll();
        final Post post = all.get(0);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void post_수정된다(){
        final Post savedPost = postRepository.save(Post.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        final Long updateId = savedPost.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        final PostUpdateRequestDto requestDto = PostUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/v1/post/" + updateId;

        final HttpEntity<PostUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        final ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        final List<Post> all = postRepository.findAll();
        final Post post = all.get(0);
        assertThat(post.getTitle()).isEqualTo(expectedTitle);
        assertThat(post.getContent()).isEqualTo(expectedContent);
    }
}