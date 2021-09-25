package com.joaquinlw.testensolvers.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaquinlw.testensolvers.models.dao.IItemDao;
import com.joaquinlw.testensolvers.models.entities.Item;

@Controller
public class ItemController {
	
	@Autowired
	private IItemDao itemDao;
	
	@GetMapping("/items")
	public String index(Map<String, Object> model) {
		Item item = new Item();
		List<Item> items = itemDao.findAll();
		model.put("item", item);
		model.put("items", items);
		return "items";
	}
	
	@PostMapping("/items")
	public String store(Item item) {
		item.setDone(false);
		itemDao.saveItem(item);
		return "redirect:items";	
	}

}
