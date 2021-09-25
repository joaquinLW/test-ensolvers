package com.joaquinlw.testensolvers.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joaquinlw.testensolvers.models.entities.User;

@Repository
public class UserDao implements IUsersDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return em.createQuery("from User").getResultList();
	}

	@Override
	@Transactional
	public void saveUser(User user) {
		em.persist(user);
	}

}
