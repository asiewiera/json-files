package com.asiewiera.jsonfiles.repositories;

import com.asiewiera.jsonfiles.entities.TestDao;
import org.springframework.data.repository.CrudRepository;



public interface TestRepository extends CrudRepository<TestDao, Long> {

}
