package org.jostho.houston.manager;

import java.util.List;

import org.jostho.houston.dao.UserDao;
import org.jostho.houston.domain.User;

public class UserManagerImpl implements UserManager {

	private UserDao dao;
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}

	
	public void add(User user) {
		dao.add(user) ;
	}

	public User getUser(int id) {
		return dao.get(id) ;
	}

	public List<User> getAllUsers() {
		return dao.getAll();
	}

}
