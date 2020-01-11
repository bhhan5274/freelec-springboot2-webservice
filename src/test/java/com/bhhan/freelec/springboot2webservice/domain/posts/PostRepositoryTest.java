package com.bhhan.freelec.springboot2webservice.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Post.builder()
            .title(title)
            .content(content)
            .author("hbh5274@gmail.com")
            .build());

        final List<Post> postList = postRepository.findAll();

        final Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }
}