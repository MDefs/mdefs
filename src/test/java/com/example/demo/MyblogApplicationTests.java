package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyblogApplicationTests {

    @Autowired
    private UserService userService;

    @Before
    public void initDb() {
        {
            User newUser = new User("testuser@mail.com", "testUser", "12345");
            userService.createUser(newUser);
        }
    }

    @Test
    public void testUser() {
        User user = userService.findOne("testuser@mail.com");
        Assert.assertNotNull(user);
    }

}
