package com.allure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {

    @Test
    public void userTest(){
        String name = "Ivan";
        User user = new User();
        user.setName(name);

        Assert.assertEquals(user.getName(), name);
    }

    @Test
    public void userTestNegative(){
        String name = "Ivan";
        User user = new User();
        user.setName(name);

        Assert.assertEquals(user.getName(), "John");
    }
}