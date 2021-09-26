package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaquinlw.testensolvers.models.dao.IFolderDao;
import com.joaquinlw.testensolvers.models.entities.Folder;

@Service
public class FolderService implements IFolderService {

	@Autowired
	private IFolderDao folderDao;
	
	@Override
	public List<Folder> findAll() {
		return folderDao.findAll();
	}

	@Override
	public void saveFolder(Folder folder) {
		folderDao.saveFolder(folder);
	}

	@Override
	public Folder getFolderById(Long id) {
		return folderDao.getFolderById(id);
	}
	
	@Override
	public void updateFolder(Folder folder) {
		folderDao.updateFolder(folder);
	}
	
	@Override
	public void deleteFolder(Folder folder) {
		folderDao.deleteFolder(folder);
	}

}
