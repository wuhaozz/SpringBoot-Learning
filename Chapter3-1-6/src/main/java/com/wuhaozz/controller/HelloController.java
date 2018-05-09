package com.wuhaozz.controller;

import com.wuhaozz.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误.error");
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2.error");
    }

}
