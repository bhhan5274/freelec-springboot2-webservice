package com.bhhan.freelec.springboot2webservice.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by hbh5274@gmail.com on 2020-01-18
 * Github : http://github.com/bhhan5274
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
