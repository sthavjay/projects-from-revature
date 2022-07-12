package com.revature.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	
	public Users findUserByUserName(String userName);

}
