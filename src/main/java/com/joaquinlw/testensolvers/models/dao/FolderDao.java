package com.joaquinlw.testensolvers.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joaquinlw.testensolvers.models.entities.Folder;

@Repository
public interface FolderDao extends CrudRepository<Folder,Long> {
	
}
