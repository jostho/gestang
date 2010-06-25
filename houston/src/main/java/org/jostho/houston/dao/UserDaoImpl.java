package org.jostho.houston.dao;

import java.util.List;

import org.jostho.houston.domain.User;

public class UserDaoImpl implements UserDao {

	private List<User> users ;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void add(User user) {
		throw new UnsupportedOperationException();
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
