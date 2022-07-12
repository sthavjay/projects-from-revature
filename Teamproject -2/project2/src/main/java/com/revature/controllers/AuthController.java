package com.revature.controllers;



import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.services.AuthServices;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthServices as;
	private static Logger log = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	public AuthController(AuthServices as) {
		super();
		this.as = as;
	}
	@PostMapping
	public ResponseEntity<String> login(@RequestParam(name="username")String userName, @RequestParam(name="password")String password){
		
		MDC.put("requestId",UUID.randomUUID().toString());
		log.debug("starting login");

		String token = as.login(userName, password);
		// String verifiedToken = as.verify(token);
		
		HttpHeaders hh = new HttpHeaders();
		
		hh.set("Authorization", token);
		
		log.info(MDC.get("Login successful"));
		
		return new ResponseEntity<>("Login successful", hh, HttpStatus.ACCEPTED);
		
	}//End login()
	
	

}
