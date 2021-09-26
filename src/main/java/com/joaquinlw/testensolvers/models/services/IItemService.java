package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.Item;

public interface IItemService {

	public List<Item> findAll();
	public void saveItem(Item item);
	
}
