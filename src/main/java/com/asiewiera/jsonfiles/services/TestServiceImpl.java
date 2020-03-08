package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.converters.TestDaoConverter;
import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.Answer;
import com.asiewiera.jsonfiles.entities.TestDao;
import com.asiewiera.jsonfiles.repositories.TestRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Data
public class TestServiceImpl implements TestService {


    @Autowired
     private TestRepository testRepository;

    @Autowired
    private  TestDaoConverter testDaoConverter;


    @Override
    public Optional<TestDao> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public TestDao save(TestDto testDto) {
        TestDao testDaoToSave = testRepository.save(testDaoConverter.apply(testDto));
        return testRepository.save(testDaoToSave);
    }

    @Override
    public Optional<TestDao> findRandomTest() {
        Optional<TestDao> testDaoOptional = Optional.empty();
        Long count = testRepository.count();
        if(count==0){
            return Optional.empty();
        }
        Random x = new Random();
        boolean newDaoExists = false;
        while(!newDaoExists){
            Long id = (long) (Math.random() * (count));
            testDaoOptional = testRepository.findById(id);
            if(testDaoOptional.isPresent()){
                newDaoExists = true;
            }
        }
        return testDaoOptional;
    }

    @Override
    public List<TestDao> findAll() {
        Iterable<TestDao> testDaoIterable = testRepository.findAll();
        return StreamSupport.stream(testDaoIterable.spliterator(),true).collect(Collectors.toList());
    }
}
