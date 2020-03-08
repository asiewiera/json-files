package com.asiewiera.jsonfiles.services;

import com.asiewiera.jsonfiles.dtos.TestDto;
import com.asiewiera.jsonfiles.entities.TestDao;
import org.junit.Test;

import java.util.List;

public interface TestService {

    List<TestDao>  findAll();
    TestDao findById(Long id);
    TestDao save(TestDto testDto);
}
