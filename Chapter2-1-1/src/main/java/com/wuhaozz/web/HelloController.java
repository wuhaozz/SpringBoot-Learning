package com.wuhaozz.web;

import com.wuhaozz.BlogProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private BlogProperties blogProperties;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World";
    }

    @RequestMapping("/getBlogProperties")
    public BlogProperties getBlogProperties() {
        return blogProperties;
    }

}
