//package com.revature.Services;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.revature.dtos.CustomerDTO;
//import com.revature.models.Customer;
//import com.revature.repositories.CustomerRepository;
//
//@Service
//public class AuthService {
//	
//	
//	
//	private CustomerRepository cr;
//	
//	public static final Logger log = LoggerFactory.getLogger(AuthService.class);
//	
//	@Autowired
//	public AuthService(CustomerRepository cr) {
//		super();
//		this.cr = cr;
//	} 
//	
//	public CustomerDTO login(String username, String password) {
//		Customer principal = cr.findCustomerbyUsername(username);
//		if(principal == null || !password.equals(principal.getPassword())) {
//			return null;
//		}
//		log.info("user successfully logged in"+ principal.getId()+"," + principal.getUsername());
//	
//		return new CustomerDTO(principal);
//		
//		}
//	
//	public String generateToken(CustomerDTO principal) {
//		return "id :" + principal.getId() + "name :"+principal.getUsername();
//		
//	}
//}