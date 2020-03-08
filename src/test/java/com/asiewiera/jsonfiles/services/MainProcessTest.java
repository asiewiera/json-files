package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.dtos.TestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MainProcessTest {
    @Autowired
    MainProcess mainProcess;

    @Test
    public void startTestShouldReturnTestDto() {
      TestDto testDto = mainProcess.startTest();

    }
}