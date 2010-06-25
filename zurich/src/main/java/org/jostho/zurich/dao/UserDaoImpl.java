package org.jostho.zurich.dao;

import java.util.List;

import org.jostho.zurich.domain.User;

public class UserDaoImpl implements UserDao {

	private List<User> users ;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User get(int id) {
		for (User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}

	public List<User> getAll() {
		return users;
	}

}
