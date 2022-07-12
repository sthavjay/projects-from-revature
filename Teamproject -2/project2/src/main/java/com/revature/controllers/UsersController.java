package com.revature.controllers;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.DTOs.UsersDTO;
import com.revature.models.Users;
import com.revature.services.UsersServices;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	private UsersServices us;
	private static Logger log =LoggerFactory.getLogger(UsersController.class);
	

	@Autowired
	public UsersController(UsersServices us) {
		super();
		this.us = us;
	}

	@GetMapping
	public ResponseEntity<List<Users>> getAll(){
		
		log.info((String) MDC.get("userToken"));
		return new ResponseEntity<>(us.getAll(), HttpStatus.OK);
		
	}//End getAll()
	
	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> getById(@PathVariable("id") int id, @RequestHeader("Authorization") String token){
		
		if(token == null) {
			
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			
		}//End if
		
		UsersDTO u = us.getUserById(id);
		log.info((String) MDC.get("userToken"));
		return new ResponseEntity<>(u, HttpStatus.OK);
		
	}//End getById()
	
	@PostMapping
	public ResponseEntity<String> createUser(@RequestBody Users user){
		
		Users u = us.createUser(user);
		return new ResponseEntity<>("User " + u.getUserName() + " has been created", HttpStatus.CREATED);
		
	}//End createUser()
	
	@PutMapping("/{id}")
	public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable("id") int id){
		
		return new ResponseEntity<>(us.updateUser(id,  user), HttpStatus.CREATED);
		
	}//End updateUser()
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") int id){
		
		us.deleteUser(id);
		return new ResponseEntity<>("User was deleted", HttpStatus.OK);
		
	}//End DeleteById
	
	
	
	
	

}
