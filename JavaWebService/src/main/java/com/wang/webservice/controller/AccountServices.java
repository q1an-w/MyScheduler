package com.wang.webservice.controller;

import com.wang.webservice.config.LoginManager;
import com.wang.webservice.model.JwtRequest;
import com.wang.webservice.mongodb.model.User;
import com.wang.webservice.mongodb.repository.MySchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wang.webservice.config.JwtTokenUtil;
import com.wang.webservice.model.JwtResponse;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountServices {
	@Autowired
	private MySchedulerRepository schedulerRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		LoginManager.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());


		final String token = jwtTokenUtil.generateToken(authenticationRequest.getUsername());

		return ResponseEntity.ok(new JwtResponse(token));
	}
	@RequestMapping(value = "/testdb", method = RequestMethod.POST)
	public ResponseEntity<?> testdb()
			throws Exception {
		schedulerRepo.save(new User());
		System.out.println("test");


		return ResponseEntity.ok("testdb add");
	}


}
