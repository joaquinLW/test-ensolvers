package com.joaquinlw.testensolvers.models.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.joaquinlw.testensolvers.models.entities.Item;

public interface IItemService {

	public List<Item> findAll();
	public Item saveItem(Item item);
	public Optional<Item> getItemById(Long id);
	public boolean deleteItem(Long id);
	public ArrayList<Item> getItemsByFolderId(Long id);
	
}
