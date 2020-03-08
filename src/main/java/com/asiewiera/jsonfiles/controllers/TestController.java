package com.asiewiera.jsonfiles.controllers;

import com.asiewiera.jsonfiles.converters.TestDtoConverter;
import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import com.asiewiera.jsonfiles.services.MainProcess;
import com.asiewiera.jsonfiles.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE}, path = "/api/test")
@Validated
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestDtoConverter testDtoConverter;

    @Autowired
    private MainProcess mainProcess;

    @GetMapping(value = "/start")
    TestDto startTest() {
        return mainProcess.startTest();

    }

    @GetMapping(value = "/next")
    TestDto next() {
        return mainProcess.getNextQuestion();
    }

    @GetMapping(value = "/previous")
    TestDto previous() {
        return mainProcess.getPreviousQuestion();
    }

    @GetMapping(value = "/stop")
    List<TestDto> stopTest() {
        return mainProcess.stopTest();
    }

}
