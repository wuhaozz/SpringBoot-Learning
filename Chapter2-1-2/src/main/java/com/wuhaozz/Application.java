package com.wuhaozz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(Application.class, args);

        Binder binder = Binder.get(context.getEnvironment());

        // 绑定简单配置
        System.out.println("例子一：简单类型");
        FooProperties foo = binder
                .bind("com.wuhaozz", Bindable.of(FooProperties.class))
                .get();
        System.out.println(foo.getFoo());


        // 绑定List配置
        System.out.println("例子二：List类型");
        List<String> post = binder
                .bind("com.wuhaozz.post", Bindable.listOf(String.class)).get();
        System.out.println(post);

        List<PostInfo> posts = binder
                .bind("com.wuhaozz.posts", Bindable.listOf(PostInfo.class)).get();
        System.out.println(posts);


    }
}
