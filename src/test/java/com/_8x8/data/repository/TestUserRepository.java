/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.data.repository;

import com._8x8.presentation.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = {"classpath:spring-test-config.xml"})
public class TestUserRepository extends AbstractTestNGSpringContextTests {

    int beforeTotalUser;
    int afterTotalUser;
    int insertUserId;
    User testUser = new User();

    @Autowired
    IUserRepository _userRepository;

    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @BeforeTest()
    public void beforeTest() {
        System.out.println("@BeforeTest");
        // List<User> mUserx = _userRepository.GetUsers();
        // beforeTotalUser = _userRepository.GetUsers().size();

        testUser.setFirstname("Tony");
        testUser.setLastname("Chen");
        testUser.setUsername("tchen");
        testUser.setPassword("welcome123");
        testUser.setGender("male");
        testUser.setEmail("tchen427@gmail.com");
        testUser.setTelephone("561-901-5698");
        testUser.setAddress("San Jose");
    }

    @Test()
    void testInsertUser() {
        beforeTotalUser = _userRepository.GetUsers().size();
        insertUserId = _userRepository.InsertUser(testUser);
        afterTotalUser = _userRepository.GetUsers().size();
        User tUser = _userRepository.GetUserById(insertUserId);
        Assert.assertEquals(tUser.getFirstname(), "Tony");
    }

    @Test()
    void testIsUserAdded() {
       // afterTotalUser = _userRepository.GetUsers().size();
        // Assert.assertEquals(afterTotalUser, (beforeTotalUser + 1));
    }

    @AfterTest()
    public void afterTest() {
        _userRepository.RemoveUserById(insertUserId);
        System.out.println("@AfterTest");
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }
}
