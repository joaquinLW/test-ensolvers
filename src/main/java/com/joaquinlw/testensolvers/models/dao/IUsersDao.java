package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.User;
//import org.springframework.security.core.userdetails.User;

public interface IUsersDao {
	
	public List<User> findAll();
	public void saveUser(User user);
	public User getUserById(long id);
	//public User getUserByEmail(String email);
	public User getUserByUsername(String username);

}
