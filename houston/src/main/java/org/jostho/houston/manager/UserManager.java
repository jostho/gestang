package org.jostho.houston.manager;

import java.util.List;

import org.jostho.houston.domain.User;

public interface UserManager {

	void add(User user);
	User getUser(int id);
	List<User> getAllUsers();
}
