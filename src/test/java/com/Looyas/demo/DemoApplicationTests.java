package com.Looyas.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//It enables full support of spring context loading and dependency injection of the beans in the tests.
@SpringBootTest // annotation that can be specified on a test class that runs Spring Boot based tests.
// It provides ability to start a fully running web server listening on any defined or random port.

public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

}
