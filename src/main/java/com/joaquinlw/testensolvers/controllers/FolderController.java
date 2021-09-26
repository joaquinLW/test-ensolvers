package com.joaquinlw.testensolvers.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaquinlw.testensolvers.models.dao.IFolderDao;
import com.joaquinlw.testensolvers.models.entities.Folder;
import com.joaquinlw.testensolvers.models.entities.User;
import com.joaquinlw.testensolvers.models.services.IFolderService;
import com.joaquinlw.testensolvers.models.services.IUserService;

@Controller
public class FolderController {

	@Autowired
	private IFolderService folderService;

	@Autowired
	private IUserService userService;

	@GetMapping({ "/folders", "", "/", "/index" })
	public String index(Model model) {
		Folder folder = new Folder();
		List<Folder> folders = folderService.findAll();
		model.addAttribute("title", "Folders");
		model.addAttribute("folder", folder);
		model.addAttribute("folders", folders);
		return "folders";
	}

	//@GetMapping("/folders/{id}")
	/*
	 * public String index(Map<String, Object> model, @PathVariable long id) {
	 * Folder folder = new Folder(); User user = userService.getUserById(id);
	 * List<Folder> folders = user.getFolders(); model.put("title", "Folders of " +
	 * user.getUsername()); model.put("user", user); model.put("folder", folder);
	 * model.put("folders", folders); return "folders"; }
	 */

	@PostMapping({ "/folders", "", "/", "index" })
	public String store(Folder folder) {
		//folder.setId(Long.parseLong("0"));
		folderService.saveFolder(folder);
		return "redirect:folders";
	}

	@GetMapping("/folders/edit/{id}")
	public String edit(Map<String, Object> model, @PathVariable Long id) {
		Folder folder = folderService.getFolderById(id);
		model.put("folder", folder);
		model.put("title", "Edit Folder");
		return "edit-folder";
	}

	@PostMapping({"/folders/edit/{id}" })
	public String update(Folder folder, @PathVariable Long id) {
		folder.setId(id);
		folderService.updateFolder(folder);
			
		return "redirect:/";
	}
	
	@GetMapping("/folders/delete/{id}")
	public String deleteFolder(@PathVariable Long id) {
		Folder folder = folderService.getFolderById(id);
		folderService.deleteFolder(folder);
		return "redirect:/";
	}
}
