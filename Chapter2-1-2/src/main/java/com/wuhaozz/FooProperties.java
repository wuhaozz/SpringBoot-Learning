package com.wuhaozz;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "com.wuhaozz")
public class FooProperties {

    private String foo;

}
