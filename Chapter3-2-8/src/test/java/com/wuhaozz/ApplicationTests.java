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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // 测试完后回滚
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "CCC");
        map.put("age", 40);
        int i = userMapper.insertByMap(map);
        System.out.println(i);
        List<User> list = userMapper.findByName("CCC");
        Assert.assertEquals(40, list.get(0).getAge().intValue());

        // insert一条数据，并select出来验证
        userMapper.insert("BBB", 20);
        list = userMapper.findByName("BBB");
        Assert.assertEquals(20, list.get(0).getAge().intValue());


        User u = list.get(0);
        Assert.assertEquals(20, u.getAge().intValue());

        // update一条数据，并select出来验证
        u.setAge(30);
        userMapper.update(u);
        list = userMapper.findByName("BBB");
        Assert.assertEquals(30, list.get(0).getAge().intValue());

        // 删除这条数据，并select验证
        userMapper.delete(u.getId());
        list = userMapper.findByName("BBB");
        Assert.assertEquals(0, list.size());
    }

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        List<User> userList = userMapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getName());
        }
    }

}
