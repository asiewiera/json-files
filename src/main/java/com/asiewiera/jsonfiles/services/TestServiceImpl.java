package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.converters.TestDaoConverter;
import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import com.asiewiera.jsonfiles.repositories.TestRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Data
public class TestServiceImpl implements TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    TestDaoConverter testDaoConverter;

    @Override
    public List<TestDao> findAll() {
        return null;

    }

    @Override
    public TestDao findById(Long id) {
        return null;
    }

    @Override
    public TestDao save(TestDto testDto) {
        TestDao testDaoToSave = testRepository.save(testDaoConverter.apply(testDto));
        return testRepository.save(testDaoToSave);
    }
}
