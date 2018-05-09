package com.wuhaozz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

    @Autowired
    private BlogProperties blogProperties;


    @Test
    public void getHello() throws Exception {
        Assert.assertEquals(blogProperties.getName(), "wuhaozz");
        Assert.assertEquals(blogProperties.getTitle(), "Spring Boot教程");
    }

}

