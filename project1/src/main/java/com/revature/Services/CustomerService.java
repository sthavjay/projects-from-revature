package com.revature.Services;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dtos.CustomerDTO;
import com.revature.exceptions.BobaNotFoundException;
import com.revature.models.Customer;
import com.revature.repositories.CustomerRepository;

public class CustomerService {
	private CustomerRepository cr;
	
	@Autowired
	public CustomerService(CustomerRepository cr) {
		super();
		this.cr = cr;
	}
	
	public List<Customer> getCustomer() {
		return cr.findAll();
	}

	
	public CustomerDTO getCustomerById(int id) throws AccountNotFoundException{	
		return new CustomerDTO(cr.findById(id).orElseThrow(AccountNotFoundException::new));
	}
	
	
	@Transactional
	public Customer createCustomer(Customer name) {
				return cr.save(name);
	}


}
