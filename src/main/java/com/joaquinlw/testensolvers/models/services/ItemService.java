package com.joaquinlw.testensolvers.models.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaquinlw.testensolvers.models.dao.ItemDao;
import com.joaquinlw.testensolvers.models.entities.Item;

@Service
public class ItemService implements IItemService {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public ArrayList<Item> findAll() {
		return (ArrayList<Item>) itemDao.findAll();
	}

	@Override
	public Item saveItem(Item item) {
		return itemDao.save(item);
	}
	
	@Override
	public Optional<Item> getItemById(Long id) {
		return itemDao.findById(id);
	}
	
	@Override
	public boolean deleteItem(Long id) {
		try {
			itemDao.deleteById(id);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	@Override
	public ArrayList<Item> getItemsByFolderId(Long id){
		return itemDao.findByFolderId(id);
	}
}
