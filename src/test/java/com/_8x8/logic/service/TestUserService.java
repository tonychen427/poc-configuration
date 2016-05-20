/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com._8x8.logic.service;

import com._8x8.presentation.model.UserPhoneLog;
import java.util.ArrayList;
import java.util.List;
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
public class TestUserService extends AbstractTestNGSpringContextTests {

    List<UserPhoneLog> _userPhoneLogs;

    @Autowired
    IUserPhoneLogService _UserPhoneLogSerice;
    
    @BeforeSuite()
    public void beforeSuite() {
        System.out.println("@BeforeSuite");
    }

    @BeforeTest()
    public void beforeTest() {
        System.out.println("@BeforeTest");
        _userPhoneLogs = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            UserPhoneLog mUserPhoneLog = new UserPhoneLog();
            mUserPhoneLog.setAnswer(true);
            mUserPhoneLog.setTrasfer(false);
            mUserPhoneLog.setTrasfer(false);
            _userPhoneLogs.add(mUserPhoneLog);
        }
    }

    @Test()
    void testTotalAnswer() {
        System.out.println("getTotalAnswer equal to 3");
        int totalAnswer = _UserPhoneLogSerice.getTotalAnswerByUserPhoneLog(_userPhoneLogs);
        
        Assert.assertNotNull(totalAnswer);
        Assert.assertEquals(totalAnswer, 3);
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println("@AfterSuite");
    }

    @AfterTest()
    public void afterTest() {
        System.out.println("@AfterTest");
    }

}
