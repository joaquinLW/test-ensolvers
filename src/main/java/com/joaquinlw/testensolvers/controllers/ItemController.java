package com.joaquinlw.testensolvers.controllers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaquinlw.testensolvers.models.dao.FolderDao;
import com.joaquinlw.testensolvers.models.dao.ItemDao;
import com.joaquinlw.testensolvers.models.entities.Folder;
import com.joaquinlw.testensolvers.models.entities.Item;
import com.joaquinlw.testensolvers.models.services.FolderService;
import com.joaquinlw.testensolvers.models.services.IFolderService;
import com.joaquinlw.testensolvers.models.services.IItemService;

@RestController
public class ItemController {

	@Autowired
	private IItemService itemService;
	
	@Autowired
	private IFolderService folderService;

	@GetMapping("/items/{id}")
	public ArrayList<Item> index(@PathVariable Long id) {
		return itemService.getItemsByFolderId(id);
	}

	@PostMapping("/items")
	public Item store(@RequestBody Item item) {
		return itemService.saveItem(item);
	}

	@DeleteMapping("/items/{id}")
	public boolean deleteItem(@PathVariable Long id) {
		return itemService.deleteItem(id);
	}
}
