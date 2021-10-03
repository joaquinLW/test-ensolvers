package com.joaquinlw.testensolvers.models.services;

import java.util.ArrayList;
import java.util.Optional;

import com.joaquinlw.testensolvers.models.entities.Folder;

public interface IFolderService {

	public ArrayList<Folder> findAll();
	public Folder saveFolder(Folder folder);
	public Optional<Folder> getFolderById(Long id);
	public boolean deleteFolder(Long folder);
	
}
