package org.jostho.zurich.dao;

import java.util.List;

import org.jostho.zurich.domain.User;

public interface UserDao {
	
	User get(int id);	
	List<User> getAll();
}
