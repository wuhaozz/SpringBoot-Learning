package com.wuhaozz;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@ToString
public class BlogProperties {

    @Value("${com.wuhaozz.blog.name}")
    private String name;

    @Value("${com.wuhaozz.blog.title}")
    private String title;

    @Value("${com.wuhaozz.blog.desc}")
    private String desc;

    @Value("${com.wuhaozz.blog.value}")
    private String value;

    @Value("${com.wuhaozz.blog.number}")
    private int number;

    @Value("${com.wuhaozz.blog.bignumber}")
    private long bignumber;

    @Value("${com.wuhaozz.blog.test1}")
    private int test1;

    @Value("${com.wuhaozz.blog.test2}")
    private int test2;

}
