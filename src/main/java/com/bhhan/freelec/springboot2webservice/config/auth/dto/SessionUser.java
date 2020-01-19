package com.bhhan.freelec.springboot2webservice.config.auth.dto;

import com.bhhan.freelec.springboot2webservice.domain.users.User;
import lombok.Getter;

import java.io.Serializable;

/**
 * Created by hbh5274@gmail.com on 2020-01-18
 * Github : http://github.com/bhhan5274
 */

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
