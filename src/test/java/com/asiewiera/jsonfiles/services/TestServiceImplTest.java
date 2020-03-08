package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.entities.TestDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceImplTest {

    @Autowired
    TestService testService;

    @Test
    public void shouldFindById() {
       Optional<TestDao> testDaoOptional =  testService.findById(1l);
       TestDao testDao =  testDaoOptional.get();
    }


    @Test
    public void shouldFindRandomTest() {
        Optional<TestDao> testDaoOptional =  testService.findRandomTest();
        Assert.assertTrue(testDaoOptional.isPresent());
    }

}