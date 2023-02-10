package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        var context = new AnnotationConfigApplicationContext(SpringConfig.class);
        var service = context.getBean("userService", UserService.class);
        service.insertUser();
    }

}
