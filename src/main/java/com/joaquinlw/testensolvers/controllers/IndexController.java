package com.joaquinlw.testensolvers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joaquinlw.testensolvers.models.dao.IUsersDao;

@Controller
public class IndexController {

	@Autowired
	private IUsersDao userDao;
	
	@GetMapping({"","/","/index"})
	public String index(Model model) {
		return "login";
	}
	
}
