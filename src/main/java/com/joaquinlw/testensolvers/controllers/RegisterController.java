package com.joaquinlw.testensolvers.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joaquinlw.testensolvers.models.dao.IUsersDao;
import com.joaquinlw.testensolvers.models.entities.User;

@Controller
public class RegisterController {
	
	@Autowired
	private IUsersDao userDao;
	
	@GetMapping({"/register"})
	public String index(Map<String, Object> model) {
		User user = new User();
		model.put("user", user);
		return "register";
	}
	
	@PostMapping("/register")
	public String store(User user) {
		userDao.saveUser(user);
		return "redirect:index";
	}

}
