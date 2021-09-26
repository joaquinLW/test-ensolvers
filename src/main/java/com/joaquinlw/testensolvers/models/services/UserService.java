package com.joaquinlw.testensolvers.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaquinlw.testensolvers.models.dao.IUsersDao;
import com.joaquinlw.testensolvers.models.entities.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUsersDao userDao;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
		
	}
	
	public User getUserById(long id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public User validateLogin(String username, String pass) {
		User user = userDao.getUserByUsername(username);
		if(user != null)
			if(user.getUsername() == username && user.getPassword() == pass)
				return user;
			else
				return null;
		return null;
	}

}
