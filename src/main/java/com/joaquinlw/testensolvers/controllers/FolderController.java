package com.joaquinlw.testensolvers.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaquinlw.testensolvers.models.dao.IFolderDao;
import com.joaquinlw.testensolvers.models.entities.Folder;

@Controller
public class FolderController {

	@Autowired
	private IFolderDao folderDao;
	
	@GetMapping("/folders")
	public String index(Map<String, Object> model) {
		Folder folder = new Folder();
		List<Folder> folders = folderDao.findAll();
		model.put("folder", folder);
		model.put("folders", folders);
		return "folders";
	}
	
	@PostMapping("/folders")
	public String store(Folder folder) {
		folderDao.saveFolder(folder);
		return "redirect:folders";
	}
}
