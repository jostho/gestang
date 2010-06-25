package org.jostho.houston.dao;

import java.util.List;

import org.jostho.houston.domain.User;

public interface UserDao {
	
	void add(User user);
	User get(int id);	
	List<User> getAll();
}
