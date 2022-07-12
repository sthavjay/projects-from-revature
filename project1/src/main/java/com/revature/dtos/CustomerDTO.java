package com.revature.dtos;


import com.revature.models.Customer;

public class CustomerDTO{
	
	
	private int id;
	private String username;
	
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public CustomerDTO(Customer user) {
		id = user.getId();
		username = user.getUsername();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", username=" + username + "]";
	}
	
	
}