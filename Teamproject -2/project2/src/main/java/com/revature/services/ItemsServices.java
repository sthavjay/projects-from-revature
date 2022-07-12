package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.DTOs.ItemsDTO;
import com.revature.exceptions.ItemsNotFoundException;
import com.revature.models.Items;
import com.revature.persistence.ItemsRepository;
import com.revature.persistence.UsersRepository;

@Service
public class ItemsServices {

	private ItemsRepository ir;
	private UsersRepository ur;
	private static Logger log = LoggerFactory.getLogger(ItemsServices.class);

	@Autowired
	public ItemsServices(ItemsRepository ir, UsersRepository ur) {
		super();
		this.ir = ir;
		this.ur = ur;
	}

	private ItemsDTO ItemsDTO(Items item) {

		log.info(MDC.get("userToken"));
		return ItemsDTO(item);
	}

	public Items getItemsById(int id) throws ItemsNotFoundException {
		
		Items i = ir.findById(id).orElseThrow(ItemsNotFoundException::new);
	
		log.info("found by id ", i);
		return i;

	}// End getItemById()

	@Transactional
	public Items createItems(Items newItem) {

		log.info("created an item ", newItem);
		return ir.save(newItem);

	}// End createItems

	public List<Items> getAll() {

		log.info(MDC.get("userToken"));
		return ir.findAll();

	}// End getAll()

	@Transactional
	public Items updateItems(int id, Items item) {

		Items it = ir.findById(id).orElseThrow(IllegalArgumentException::new);
		item.setItemId(it.getItemId());

		log.debug("updating new flavor");
		return ir.save(item);

	}// End updateItems()

	@Transactional
	public void deleteItems(int id) {

		log.error("deleted a item");
		log.debug("deleting new items");
		ir.deleteById(id);

	}// End deleteItems()

}
