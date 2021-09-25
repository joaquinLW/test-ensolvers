	package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.Item;

public interface IItemDao {

	public List<Item> findAll();
	public void saveItem(Item item);
}
