//package com.revature.Controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.revature.Services.AuthService;
//import com.revature.Services.CustomerService;
//import com.revature.dtos.CustomerDTO;
//import com.revature.models.Customer;
//
//@RestController
//@RequestMapping("/customer")
//public class CustomerController {
//	
//	private CustomerService cs;
//	private AuthService as;
//
//	@Autowired
//	public CustomerController ( CustomerService cs, AuthService as) {
//	super();
//	this.cs = cs;
//	this.as = as;
//	}
//
//	@GetMapping
//	public ResponseEntity<List<CustomerDTO>> getCustomer(@RequestHeader(value = "Authorization", required = false) String token) {
//
//		return new ResponseEntity<>(cs.getCustomer(), HttpStatus.OK);	
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<CustomerDTO> getCustomerrById(@RequestHeader(value = "Authorization", required = false) String token, @PathVariable("id") int id) {
//		
//		return new ResponseEntity<>(cs.getCustomerById(id), HttpStatus.OK);	
//	}
//	
//	@PostMapping
//	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) {
//		Customer newcustomer = cs.createCustomer(customer));
//		return new ResponseEntity<>(newcustomer, HttpStatus.CREATED);
//	}
//
//}
