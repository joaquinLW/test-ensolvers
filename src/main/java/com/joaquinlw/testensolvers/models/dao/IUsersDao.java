package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import com.joaquinlw.testensolvers.models.entities.User;

public interface IUsersDao {
	
	public List<User> findAll();
	public void saveUser(User user);

}
