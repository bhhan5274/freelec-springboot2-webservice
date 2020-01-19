package com.bhhan.freelec.springboot2webservice.common;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by hbh5274@gmail.com on 2020-01-19
 * Github : http://github.com/bhhan5274
 */

@ExtendWith(SpringExtension.class)
@ActiveProfiles(value = "test")
public abstract class BaseTest {
}
