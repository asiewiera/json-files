package com.asiewiera.jsonfiles.converters;

import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class TestDaoConverter implements Function<TestDto, TestDao> {
    @Override
    public TestDao apply(TestDto testDto) {
        return new TestDao(null,testDto.getCategory(),testDto.getSubCategory(),testDto.getMultiSelect(),testDto.getText(),testDto.getAnswers(),testDto.getExplanation());
    }
}
