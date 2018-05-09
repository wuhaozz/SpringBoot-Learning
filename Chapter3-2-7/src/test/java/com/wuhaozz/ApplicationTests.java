package com.wuhaozz;

import com.wuhaozz.domain.User;
import com.wuhaozz.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 测试完后回滚
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        userMapper.insert("AAA", 20);
        List<User> u = userMapper.findByName("AAA");
        Assert.assertEquals(20, u.get(0).getAge().intValue());
    }

}
