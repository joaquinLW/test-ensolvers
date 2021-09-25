package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaquinlw.testensolvers.models.entities.Item;

@Repository
public class ItemDao implements IItemDao {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		return em.createQuery("from Item").getResultList();
	}

	@Override
	@Transactional
	public void saveItem(Item item) {
		em.persist(item);
	}

}
