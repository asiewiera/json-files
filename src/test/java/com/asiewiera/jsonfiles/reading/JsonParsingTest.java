package com.asiewiera.jsonfiles.reading;

import com.asiewiera.jsonfiles.dtos.TestDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JsonParsingTest {

    @Test
    public void shouldReadJsonAndReturnTestList() {
     List<TestDto> testDtoList = JsonParsing.readJsonFile("questions.json");
     //testDtoList.stream().forEach(System.out::println);
     Assert.assertFalse(testDtoList.isEmpty());
    }

    @Test
    public void shouldListFilesInDirectory() {
       List<String> paths =     JsonParsing.listFilesInDirectory();
       paths.stream().forEach(System.out::println);
    }
}