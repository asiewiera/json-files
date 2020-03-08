package com.asiewiera.jsonfiles.repositories;

import com.asiewiera.jsonfiles.entities.TestDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends CrudRepository<TestDao, Long> {

}
