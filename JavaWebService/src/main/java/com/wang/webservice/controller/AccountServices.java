package com.wang.webservice.controller;

import java.util.Objects;

import com.wang.webservice.config.LoginManager;
import com.wang.webservice.model.JwtRequest;
import com.wang.webservice.mongodb.repository.MySchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wang.webservice.config.JwtTokenUtil;
import com.wang.webservice.model.JwtResponse;

import com.wang.webservice.mongodb.model.*;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountServices {
	@Autowired
	private MySchedulerRepository schedulerRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailsService jwtInMemoryUserDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws Exception {

		LoginManager.authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = jwtInMemoryUserDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	@RequestMapping(value = "/testdb", method = RequestMethod.POST)
	public ResponseEntity<?> testdb()
			throws Exception {
		schedulerRepo.save(new User());


		return ResponseEntity.ok("testdb add");
	}


}
