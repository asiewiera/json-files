package com.asiewiera.jsonfiles.converters;

import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class TestDtoConverter  implements Function<TestDao, TestDto> {
    @Override
    public TestDto apply(TestDao testDao) {
        return new TestDto(testDao.getId(),testDao.getCategory(),testDao.getSubCategory(),testDao.getMultiSelect(),testDao.getText(),testDao.getAnswerList(),testDao.getExplanation());
    }
}
