package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.converters.TestDtoConverter;
import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.Answer;
import com.asiewiera.jsonfiles.entities.TestDao;
import com.asiewiera.jsonfiles.exceptions.EntityNotFoundException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Component
public class MainProcess {

    private boolean running;
    private List<TestDto> questionDtoList;
    private TestDto questionVisible;
    private int currentIndex;

    @Autowired
    TestService testService;

    @Autowired
    TestDtoConverter testDtoConverter;


    public TestDto startTest() {
        if (running) {
            System.out.println("Test already running");
            return null;
        }
        questionDtoList = testService.findAll().stream().map(e -> testDtoConverter.apply(e)).collect(Collectors.toList());
        running = true;
        currentIndex = 0;
        questionVisible = questionDtoList.get(currentIndex);
        return questionVisible;
    }

    public List<TestDto> stopTest() {
        running = false;
        return questionDtoList;
    }

    public TestDto getNextQuestion() {
        if (running) {
            if (currentIndex < questionDtoList.size() - 1) {
                currentIndex++;
            } else {
                System.out.println("Last Question");
            }
            questionVisible = questionDtoList.get(currentIndex);
            return questionVisible;
        } else {
            System.out.println("No running task");
            throw new EntityNotFoundException("No running test");
        }
    }

    public TestDto getPreviousQuestion() {
        if (running) {
            if (currentIndex > 0) {
                currentIndex--;
            } else {
                System.out.println("First Question");
            }
            questionVisible = questionDtoList.get(currentIndex);
            return questionVisible;
        } else {
            System.out.println("No running test");
            throw new EntityNotFoundException("No running test");
        }
    }


}
