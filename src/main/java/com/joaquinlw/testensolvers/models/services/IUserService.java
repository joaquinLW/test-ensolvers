package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.User;

public interface IUserService {

	public List<User> findAll();
	public void saveUser(User user);
	public User validateLogin(String username, String pass);
	public User getUserById(long id);
	
}
