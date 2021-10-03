	package com.joaquinlw.testensolvers.models.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.joaquinlw.testensolvers.models.entities.Item;

public interface ItemDao extends CrudRepository<Item, Long> {
	public abstract ArrayList<Item> findByFolderId(Long id);
}
