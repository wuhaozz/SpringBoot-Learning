package com.wuhaozz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

// 不能使用@RestController，因为会直接返回json，而不是使用模版
// @RestController
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.wuhaozz.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }


    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/")
    public String page() {
        return "system/index";
    }


    /**
     * 跳转
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String page2() {
        return "redirect/redirect";
    }


    /**
     * 视图
     *
     * @param model
     * @return
     */
    @RequestMapping("/model")
    public String page3(Model model) {
        model.addAttribute("name", "wuhao");
        return "hello";
    }


}
