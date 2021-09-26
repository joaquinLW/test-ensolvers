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
import com.joaquinlw.testensolvers.models.services.IFolderService;
import com.joaquinlw.testensolvers.models.services.IItemService;

@Controller
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	@Autowired
	private IFolderService folderService;
	
	@GetMapping("/items/{id}")
	public String index(Map<String, Object> model, @PathVariable String id) {
		Item item = new Item();
		Folder folder = folderService.getFolderById(Long.parseLong(id)); 
		List<Item> items = folder.getItems();
		model.put("folder", folder);
		model.put("item", item);
		model.put("items", items);
		return "items";
	}
	
	@PostMapping("/items/{id}")
	public String store(@PathVariable Long id, Item item) {
		item.setDone(false);
		item.setFolder(folderService.getFolderById(id));
		itemService.saveItem(item);
		return "redirect:/items/" + id;
	}
	
	@GetMapping("/items/edit/{id}")
	public String edit(Map<String, Object> model, @PathVariable Long id) {
		Item item = itemService.getItemById(id);
		item.setFolder(item.getFolder());
		model.put("title", "Update Item");
		model.put("item", item);
		return "edit-item";
	}

	@PostMapping("/items/edit/{id}")
	public String updateItem(Item item, @PathVariable Long id) {
		//Item item = itemService.getItemById(id);
		item.setId(id);
		itemService.updateItem(item);
		item = itemService.getItemById(id);
		return "redirect:/items/" + item.getFolder().getId();
	}
}
