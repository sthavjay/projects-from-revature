package com.revature.controllers;

import java.util.List;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exceptions.ItemsNotFoundException;
import com.revature.models.Items;
import com.revature.services.ItemsServices;

@RestController
@RequestMapping("/items")
public class ItemsController {
	
	private ItemsServices is;
	private static Logger log =LoggerFactory.getLogger(ItemsController.class);
	
	@Autowired
	public ItemsController(ItemsServices is) {
		super();
		this.is = is;
	}
	
	@GetMapping
	public ResponseEntity<List<Items>> getAll(){
		
		log.info((String) MDC.get("userToken"));
		return new ResponseEntity<>(is.getAll(), HttpStatus.OK);
		
	}//End getAll()
	
	@GetMapping("/{id}")
	public ResponseEntity<Items> getById(@PathVariable("id")int id) throws ItemsNotFoundException{
		
		return new ResponseEntity<>(is.getItemsById(id), HttpStatus.OK);
		
	}//End getById()
	
	@PostMapping
	public ResponseEntity<String> createItem(@RequestBody Items item){
		
		Items i = is.createItems(item);
		return new ResponseEntity<>("Item " + i.getItemName() + " has been created", HttpStatus.CREATED);
		
	}//End createUser()
	
	@PutMapping("/{id}")
	public ResponseEntity<Items> updateItems(@RequestBody Items item, @PathVariable("id") int id){
		
		log.warn("[insert user info here] tried to access endpoint /users/id");
		return new ResponseEntity<>(is.updateItems(id,  item), HttpStatus.CREATED);
		
	}//End updateUser()
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") int id){
		
		is.deleteItems(id);
		return new ResponseEntity<>("Item was deleted", HttpStatus.OK);
		
	}//End DeleteById
	
	
	
	

}
