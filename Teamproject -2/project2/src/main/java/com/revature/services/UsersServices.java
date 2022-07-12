package com.revature.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.DTOs.UsersDTO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Users;
import com.revature.persistence.ItemsRepository;
import com.revature.persistence.UsersRepository;

@Service
public class UsersServices {
	
	private UsersRepository ur;
	private ItemsRepository ir;
	private static Logger log = LoggerFactory.getLogger(UsersServices.class);
	
	@Autowired
	public UsersServices(UsersRepository ur, ItemsRepository ir) {
		super();
		this.ur = ur;
		this.ir = ir;
	}
	
	public UsersDTO getUserById(int id) throws UserNotFoundException{
		
		Users user = ur.findById(id).orElseThrow(UserNotFoundException::new);
		
		log.info(MDC.get("userToken"));
		return new UsersDTO(user);
				
	};//End getUserById()
	
	@Transactional
	public Users createUser(Users newUser) {
		
		return ur.save(newUser);
		
	}//End createUser();
	
	public List<Users> getAll(){
		
		log.info(MDC.get("userToken"));
		return ur.findAll();
		
	}//End getAll().
	
	@Transactional
	public Users updateUser(int id, Users user) {
		
		Users u = ur.findById(id).orElseThrow(UserNotFoundException::new);
		user.setUserId(u.getUserId());
		return ur.save(user);
		
	}//End updateUser() 
	
	@Transactional
	public void deleteUser(int id) throws UserNotFoundException{
		
		getUserById(id);
		ur.deleteById(id);
		
	}//End deleteUser()
	
	
	
	

}
