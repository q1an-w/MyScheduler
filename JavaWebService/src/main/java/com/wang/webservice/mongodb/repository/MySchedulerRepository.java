package com.wang.webservice.mongodb.repository;

import com.wang.webservice.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySchedulerRepository extends MongoRepository<User,String> {

}
