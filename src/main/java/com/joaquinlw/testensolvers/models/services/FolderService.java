package com.joaquinlw.testensolvers.models.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaquinlw.testensolvers.models.dao.FolderDao;
import com.joaquinlw.testensolvers.models.entities.Folder;

@Service
public class FolderService implements IFolderService{

	@Autowired
	FolderDao folderDao;
	
	public ArrayList<Folder> findAll() {
		return (ArrayList<Folder>) folderDao.findAll();
	}

	public Folder saveFolder(Folder folder) {
		return folderDao.save(folder);
	}

	public Optional<Folder> getFolderById(Long id) {
		return folderDao.findById(id);
	}
	
	public boolean deleteFolder(Long folder) {
		try {
			folderDao.deleteById(folder);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}

}
