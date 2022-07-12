package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DTOs.UsersDTO;
import com.revature.exceptions.AuthenticationException;
import com.revature.models.Users;
import com.revature.persistence.UsersRepository;

@Service
public class AuthServices {
	
	private UsersRepository ur;
	private static Logger log = LoggerFactory.getLogger(AuthServices.class);
	
	@Autowired
	public AuthServices(UsersRepository ur) {
		super();
		this.ur = ur;
	}
	
	public String login(String userName, String password) {
		
		Users principal = ur.findUserByUserName(userName);
		
		if(principal == null || !password.equals(principal.getUserPassword())) {
			
			throw new AuthenticationException("Attepmted to login with username: " + userName);
			
		
			
		}//End if
		
		log.info(MDC.get("userToken"));
		return principal.getUserId() + " : " + principal.getUserName();
		
	}//End login()
	
//	public String verify(String token) {
//		
//		if(token == null) {
//			
//			throw new AuthenticationException("null token");
//		}
//		
//		String[] splitToken = token.split(":");
//		
//		Users principal = ur.findById(Integer.valueOf(splitToken[0])).orElse(null);
//		
//		if(principal == null || !principal.getRole().toString().equals(splitToken[1]) || !principal.getRole().toString().equals("Admin")) {
//			
//			throw new AuthenticationException("Unable to verify token of value: " + splitToken[0] + ", " + splitToken[1]); 
//		}//End of if
//		
//		log.info("toekn verified successfully");
//			
//		MDC.put("userId", token);
//		
//		return token;
//		
//	}//End of verify()
	
	

}
