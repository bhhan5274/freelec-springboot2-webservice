package com.bhhan.freelec.springboot2webservice.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hbh5274@gmail.com on 2020-02-16
 * Github : http://github.com/bhhan5274
 */
class ProfileControllerUnitTest {
    @Test
    @DisplayName("real_profile이 조회된다.")
    public void real_profile_test1(){
        String expectedProfile = "real";
        final MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        final ProfileController profileController = new ProfileController(env);
        final String profile = profileController.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    @DisplayName("real_profile이 없으면 첫번째가 조회된다.")
    public void real_profile_test2(){
        String expectedProfile = "oauth";
        final MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        final ProfileController profileController = new ProfileController(env);
        final String profile = profileController.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    @DisplayName("active_profile이 없으면 default가 조회된다.")
    public void real_profile_test3(){
        String expectedProfile = "default";
        final MockEnvironment env = new MockEnvironment();
        final ProfileController profileController = new ProfileController(env);
        final String profile = profileController.profile();
        assertThat(profile).isEqualTo(expectedProfile);
    }
}