package com.allure;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UserTest {

    private final SoftAssert asserter = new SoftAssert();

    @Test
    public void userTest() {
        String name = "Ivan";
        User user = new User();
        user.setName(name);

        asserter.assertEquals(user.getName(), name);
        asserter.assertAll();
    }

    @Test
    public void userTestNegative() {
        String name = "Ivan";
        User user = new User();
        user.setName(name);

        asserter.assertEquals(user.getName(), "John");
        asserter.assertAll();
    }
}