package com.revature.DTOs;

import java.util.Objects;

import com.revature.models.Users;

public class UsersDTO {
	
	private int id;
	private String userName;
	
	
	
	public UsersDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UsersDTO(Users users) {
		super();
		id = users.getUserId();
		userName = users.getUserName();
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		return "UsersDTO [id=" + id + ", userName=" + userName + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(id, userName);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsersDTO other = (UsersDTO) obj;
		return id == other.id && Objects.equals(userName, other.userName);
	}
	
	

}
