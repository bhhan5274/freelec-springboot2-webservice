package com.bhhan.freelec.springboot2webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hbh5274@gmail.com on 2020-01-11
 * Github : http://github.com/bhhan5274
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
