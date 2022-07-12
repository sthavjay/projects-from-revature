//package com.revature.Controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.Services.AuthService;
//import com.revature.dtos.CustomerDTO;
//
//@RestController
//@RequestMapping("/auth")
//public class AuthController {
//	
//	private AuthService as;
//
////	private CustomerDTO principal;
////	
//	private static Logger log = LoggerFactory.getLogger(AuthController.class);
//	// Better practice to use class logger over root logger as we can specify different logger configuration based on class
//	
//	@Autowired
//	public AuthController(AuthService as) {
//		super();
//		this.as = as;
//	}
//	
//	@PostMapping
//	public ResponseEntity<CustomerDTO> login (@RequestParam("username") String username, @RequestParam("password") String password){
//		CustomerDTO principal = as.login(username, password);
//		if(principal==null)
//			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//	
//	String token = as.generateToken(principal);
//			HttpHeaders header = new HttpHeaders();
//	
//			// set tokenName, value hh.set(name,value)
//		header.set("Auth", token);
//		log.info("login successfully");
//		return new ResponseEntity<>(principal, header, HttpStatus.ACCEPTED);
//		
//		}
//}
//
//
