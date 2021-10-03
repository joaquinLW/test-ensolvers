package com.joaquinlw.testensolvers.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.joaquinlw.testensolvers.models.dao.FolderDao;
import com.joaquinlw.testensolvers.models.entities.Folder;
import com.joaquinlw.testensolvers.models.entities.User;
import com.joaquinlw.testensolvers.models.services.FolderService;
import com.joaquinlw.testensolvers.models.services.IUserService;

@RestController
public class FolderController {

	@Autowired
	private FolderService folderService;

	@GetMapping({ "/folders", "", "/", "/index" })
	public ArrayList<Folder> index() {
		ArrayList<Folder> folders = folderService.findAll();
		return folders;
	}

	@PostMapping({ "/folders", "", "/", "index" })
	public Folder store(@RequestBody Folder folder) {
		return folderService.saveFolder(folder);
	}

	@GetMapping("/folders/{id}")
	public Optional<Folder> edit(Map<String, Object> model, @PathVariable Long id) {
		return folderService.getFolderById(id);
	}
	
	@DeleteMapping("/folders/{id}")
	public boolean deleteFolder(@PathVariable Long id) {
		return folderService.deleteFolder(id);
	}
}
