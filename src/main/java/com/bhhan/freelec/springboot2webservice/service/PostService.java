package com.bhhan.freelec.springboot2webservice.service;

import com.bhhan.freelec.springboot2webservice.domain.posts.Post;
import com.bhhan.freelec.springboot2webservice.domain.posts.PostRepository;
import com.bhhan.freelec.springboot2webservice.web.dto.PostListResponseDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostResponseDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostSaveRequestDto;
import com.bhhan.freelec.springboot2webservice.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        final Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        final Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc(){
        return postRepository.findAllDesc()
                .stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        final Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postRepository.delete(post);
    }
}
