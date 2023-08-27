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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountServices {
	@Autowired
	private MySchedulerRepository schedulerRepo;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	// authentication for login purposes
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest) {
		boolean auth = false;
		try{
			auth = authenticate(authenticationRequest.getId(), authenticationRequest.getPassword());
		}catch (NullPointerException e){
			return new ResponseEntity<>("null credentials", HttpStatus.BAD_REQUEST); //null id or password
		}catch (Exception e){
			return new ResponseEntity<>("unknown exception", HttpStatus.BAD_GATEWAY); //unknown excpetion
		}

		if(auth){
			final String token = jwtTokenUtil.generateToken(authenticationRequest.getId());//jwt token
			return ResponseEntity.ok(new JwtResponse(token));
		}else;
		return new ResponseEntity<>("Bad Credentials", HttpStatus.FORBIDDEN);
	}
	//signup api endpoint
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest)
			throws Exception {
		boolean doesUserExist;
		try{
			doesUserExist = doesUserExist(signupRequest.getUserEmail()) || doesUserExist(signupRequest.getUserName());
		}catch (NullPointerException e){
			return new ResponseEntity<>("null credentials", HttpStatus.BAD_REQUEST); //null id or password
		}catch (Exception e){
			return new ResponseEntity<>("unknown exception", HttpStatus.BAD_GATEWAY); //unknown excpetion
		}
		if(doesUserExist){
			return new ResponseEntity<>("User exists already", HttpStatus.BAD_REQUEST);
		}else{
			User user = new User();
			user.setAccountInfo(new AccountInfo(signupRequest.getUserEmail(), signupRequest.getUserName(),5, signupRequest.getPassword()));
			schedulerRepo.save(user);
			final String token = jwtTokenUtil.generateToken(signupRequest.getUserName());//jwt token
			return ResponseEntity.ok(new JwtResponse(token));
		}

	}
	@RequestMapping(value = "/user/{requesterID}/{userID}", method = RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable("requesterID") String requesterID, @PathVariable("userID") String userID)
			throws Exception {
		User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
		if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
			return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
		}
		//validate access level

		if(requester.getAccountInfo().getAccessLevel() >= 100){
			User targetUser = schedulerRepo.findUserByEmailOrUsername(userID);
			return ResponseEntity.ok(targetUser);
		}else return new ResponseEntity<>("not high enough access level", HttpStatus.BAD_REQUEST);
	}
	@RequestMapping(value = "/user/{requesterID}/{userID}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable("requesterID") String requesterID, @PathVariable("userID") String userID)
			throws Exception {
		//validate access level
		User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
		if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
			return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
		}
		if(requester.getAccountInfo().getAccessLevel() >= 100){
			User targetUser = schedulerRepo.findUserByEmailOrUsername(userID);
			schedulerRepo.delete(targetUser);
			return ResponseEntity.ok("successful user delete");
		}else return new ResponseEntity<>("not high enough access level", HttpStatus.BAD_REQUEST);
	}
	@RequestMapping(value = "/user/{requesterID}/{userID}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@PathVariable("requesterID") String requesterID, @PathVariable("userID") String userID, User userInfo)
			throws Exception {
		//validate access level
		User requester = schedulerRepo.findUserByEmailOrUsername(requesterID);
		if(!jwtTokenUtil.validateToken(JwtTokenUtil.getBearerTokenHeader(), requester.getAccountInfo().getUserName(),requester.getAccountInfo().getUserEmail())){
			return new ResponseEntity<>("Invalid Token", HttpStatus.FORBIDDEN);
		}
		if(requester.getAccountInfo().getAccessLevel() >= 100 || requesterID.equals(userID)){
			User targetUser = schedulerRepo.findUserByEmailOrUsername(userID);
			targetUser.updateUser(userInfo); //TBD: ADD NULL userInfo Section managing
			schedulerRepo.save(targetUser);
			return ResponseEntity.ok("successful user delete");
		}else return new ResponseEntity<>("not high enough access level", HttpStatus.BAD_REQUEST);
	}

	private boolean authenticate(String id, String password) throws Exception{

		Objects.requireNonNull(id);
		Objects.requireNonNull(password);
		User user = schedulerRepo.findUserByEmailOrUsername(id);
		if(user.getAccountInfo().getPassword().equals(password)){
			return true;
		} else return false;

	}
	private boolean doesUserExist(String id) throws Exception{

		Objects.requireNonNull(id);
		User user = schedulerRepo.findUserByEmailOrUsername(id);
        return user != null;

	}


	// test endpoint to add blank user
	/***
	@RequestMapping(value = "/testdb", method = RequestMethod.POST)
	public ResponseEntity<?> testdb()
			throws Exception {
		schedulerRepo.save(new User());
		System.out.println("test");


		return ResponseEntity.ok("testdb add");
	}
	***/


}
