package com.wang.webservice.mongodb.repository;

import com.wang.webservice.mongodb.model.Event.Event;
import com.wang.webservice.mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MySchedulerRepository extends MongoRepository<User,String> {
    @Query("{$or: [{'accountInfo.userName': '?0'},{'accountInfo.userEmail': '?0'}]}")
    public User findUserByEmailOrUsername(String id);


    @Query("{$push: {'calendar': '?0'}}")
    public void addEventToCalendar(Event event);
    @Query("{$set: {'calendar': '?1'}}") //TBD
    public void updateEventToCalendar( Event event);
    @Query("{$pull: {'calendar': '?0.eventID'}}")//test
    public void deleteEventToCalendar( Event event);



}
