package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public interface TestService {

    Optional<TestDao> findById(Long id);
    TestDao save(TestDto testDto);
    Optional<TestDao> findRandomTest();
    List<TestDao> findAll();
}
