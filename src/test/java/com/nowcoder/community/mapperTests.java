package com.nowcoder.community;

import com.nowcoder.community.dao.*;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class mapperTests {

//    UserMapper
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("jing");
        user.setEmail("123456@qq.com");
        user.setSalt("abd");
        user.setPassword("123456");
        user.setType(1);
        user.setStatus(1);
        user.setActivationCode("jidfnfd");
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }

//    DiscussPostMapper
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Test
    public void testSelectPosts() {
//        要用对象去接收他
        List<DiscussPost> list =discussPostMapper.selectDiscussPosts(149,0,10);
        for(DiscussPost post : list) {
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(149);
        System.out.println(rows);
    }

}
