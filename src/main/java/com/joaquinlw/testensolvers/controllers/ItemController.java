package com.joaquinlw.testensolvers.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaquinlw.testensolvers.models.dao.IFolderDao;
import com.joaquinlw.testensolvers.models.dao.IItemDao;
import com.joaquinlw.testensolvers.models.entities.Folder;
import com.joaquinlw.testensolvers.models.entities.Item;

@Controller
public class ItemController {
	
	@Autowired
	private IItemDao itemDao;
	
	@Autowired
	private IFolderDao folderDao;
	
	@GetMapping("/items/{id}")
	public String index(Map<String, Object> model, @PathVariable String id) {
		Item item = new Item();
		Folder folder = folderDao.getFolderById(Long.parseLong(id)); 
		List<Item> items = folder.getItems();
		model.put("folder", folder);
		model.put("item", item);
		model.put("items", items);
		return "items";
	}
	
	@PostMapping("/items/{id}")
	public String store(@PathVariable Long id, Item item) {
		item.setDone(false);
		item.setFolder(folderDao.getFolderById(id));
		itemDao.saveItem(item);
		return "redirect:/items/" + id;
	}
	

}
