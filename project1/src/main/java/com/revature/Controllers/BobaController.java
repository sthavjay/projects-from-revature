package com.revature.Controllers;

import java.util.List;

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

import com.revature.exceptions.BobaNotFoundException;
//import com.revature.Services.AuthService;
import com.revature.Services.BobaService;
import com.revature.models.Boba;

@RestController
@RequestMapping("/boba")
public class BobaController {
	
	private BobaService bs;
	//private AuthService as;

	private static final Logger log = LoggerFactory.getLogger(BobaController.class);
	
	@Autowired
	public BobaController(BobaService bs) {
		super();
		this.bs = bs;
	}
	
	@GetMapping
	public ResponseEntity<List<Boba>> getAll() {
		return new ResponseEntity<>(bs.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Boba>getById(@PathVariable("id")int id) throws BobaNotFoundException{
		return new ResponseEntity<>(bs.getBobaById(id), HttpStatus.OK);
	}
	
		
	@PostMapping
	public ResponseEntity<String> postBoba(@RequestBody Boba newboba){
		bs.createBoba(newboba);
		return new ResponseEntity<>("NewBoba is created",HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Boba> updateFlavor(@RequestBody Boba boba, @PathVariable("id") int id) throws BobaNotFoundException{
		return new ResponseEntity<>(bs.updateBoba(id,boba), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteById(@PathVariable("id")int id) throws BobaNotFoundException{
		bs.deleteBoba(id);
		log.info("boba is deleted");
		return new ResponseEntity<>("this id" + id + "has been deleted.", HttpStatus.OK);
	}
	//public ResponseEntity<Boba>
}
