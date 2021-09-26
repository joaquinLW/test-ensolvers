package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaquinlw.testensolvers.models.dao.IItemDao;
import com.joaquinlw.testensolvers.models.entities.Item;

@Service
public class ItemService implements IItemService {

	@Autowired
	private IItemDao itemDao;
	
	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public void saveItem(Item item) {
		itemDao.saveItem(item);
	}

}
