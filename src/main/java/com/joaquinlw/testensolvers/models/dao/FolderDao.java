package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaquinlw.testensolvers.models.entities.Folder;

@Repository
public class FolderDao implements IFolderDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly=true)
	@SuppressWarnings("unchecked")
	public List<Folder> findAll() {
		return em.createQuery("from Folder").getResultList();
	}

	@Override
	@Transactional
	public void saveFolder(Folder folder) {
		em.persist(folder);
		
	}
	
	

}
