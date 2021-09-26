package com.joaquinlw.testensolvers.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joaquinlw.testensolvers.models.dao.UserDao;
import com.joaquinlw.testensolvers.models.entities.User;
import com.joaquinlw.testensolvers.models.services.IUserService;

@Controller
public class LoginController {

	@Autowired
	private IUserService userService;

	//@GetMapping({ "", "/", "/index", "/login" })
	public String index(@RequestParam(value = "error", required = false) String error, Map<String, Object> model) {
		User user = new User();
		model.put("title", "Log In");
		model.put("user", user);
		return "login";
	}

	@PostMapping("/login")
	public String validateLogin(User user) {
		User userFind = userService.validateLogin(user.getUsername(), user.getPassword());
		if(userFind != null) 
		return "forward:folders/"+ userFind.getId();
		else return "redirect:/login";
	}

}
