package com.revature.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.exceptions.BobaNotFoundException;
import com.revature.models.Boba;
import com.revature.repositories.BobaRepository;
import com.revature.repositories.CustomerRepository;

@Service
public class BobaService {
	private BobaRepository br;
	Logger logger = LoggerFactory.getLogger(BobaService.class);
	
	@Autowired
	public BobaService(BobaRepository br, CustomerRepository cr) {
		super();
		this.br = br;
	}
	
	public List<Boba> getAll(){
		logger.info("Data from getall");
		return br.findAll();
		
	}

	public Boba getBobaById(int id){
		return br.findBobaById(id);
	}
	
	public List<Boba>getBobaByFlavor(String flavor) {
		return br.findBobaByFlavor(flavor);
	}
	
	@Transactional
	public Boba createBoba(Boba newBoba) {
		logger.info("new boba created ", newBoba);
		return br.save(newBoba);
	}
	
	@Transactional
	public Boba updateBoba(int id, Boba newboba) throws BobaNotFoundException {
		Boba u = br.findById(id).orElseThrow(BobaNotFoundException::new);
		newboba.setId(u.getId());
		logger.info("Data updated");
		return br.save(newboba);
	}
	
	@Transactional
	public boolean deleteBoba(int id) {
		getBobaById(id);
		br.deleteById(id);
		return true;
	}
	
	
	
	
}
