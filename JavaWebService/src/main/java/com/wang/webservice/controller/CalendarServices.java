package com.wang.webservice.controller;

import com.wang.webservice.model.JwtRequest;
import com.wang.webservice.model.SignupRequest;
import com.wang.webservice.mongodb.model.AccountInfo.AccountInfo;
import com.wang.webservice.mongodb.model.Event.Event;
import com.wang.webservice.mongodb.model.User;
import com.wang.webservice.mongodb.repository.MySchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wang.webservice.config.JwtTokenUtil;
import com.wang.webservice.model.JwtResponse;

import java.util.ArrayList;
import java.util.Objects;

public class CalendarServices {
    @Autowired
    private MySchedulerRepository schedulerRepo;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/user/load-calendar/{requesterID}", method = RequestMethod.GET)
    public ResponseEntity<?> loadCalendar(@PathVariable("requesterID") String requesterID)
            throws Exception {

        User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
        if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
            return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
        }
        //validate access level
        final ArrayList<Event> calendar = requester.getCalendar();
        return ResponseEntity.ok(calendar);
    }
    @RequestMapping(value = "/user/event/{requesterID}", method = RequestMethod.POST)
    public ResponseEntity<?> addEvent(@PathVariable("requesterID") String requesterID, @RequestBody Event event)
            throws Exception {

        User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
        if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
            return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
        }
        //validate access level
        schedulerRepo.addEventToCalendar(requesterID, event);
        return ResponseEntity.ok("calendar updated (POST)" + event);
    }
    @RequestMapping(value = "/user/event/{requesterID}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEvent(@PathVariable("requesterID") String requesterID, @RequestBody Event event)
            throws Exception {

        User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
        if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
            return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
        }
        //validate access level
        //TBD
        // UPDATE EVENT
        schedulerRepo.updateEventToCalendar(requesterID, event);
        return ResponseEntity.ok("calendar updated (PUT)" + event);
    }
    @RequestMapping(value = "/user/event/{requesterID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEvent(@PathVariable("requesterID") String requesterID, @RequestBody Event event)
            throws Exception {

        User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
        if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
            return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
        }
        //validate access level
        //TBD
        //DELETE EVENT
        schedulerRepo.deleteEventToCalendar(requesterID, event);
        return ResponseEntity.ok("calendar updated (DELETE)" + event);
    }
}
