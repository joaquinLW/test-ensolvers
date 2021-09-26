package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.Folder;

public interface IFolderService {

	public List<Folder> findAll();
	public void saveFolder(Folder folder);
	public Folder getFolderById(Long id);
	public void updateFolder(Folder folder);
	public void deleteFolder(Folder folder);
}
