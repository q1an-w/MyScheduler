package com.wang.webservice.controller;

import com.wang.webservice.model.JwtRequest;
import com.wang.webservice.model.SignupRequest;
import com.wang.webservice.mongodb.model.AccountInfo.AccountInfo;
import com.wang.webservice.mongodb.model.User;
import com.wang.webservice.mongodb.repository.MySchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wang.webservice.config.JwtTokenUtil;
import com.wang.webservice.model.JwtResponse;

import java.util.Objects;

public class CalendarServices {
}
