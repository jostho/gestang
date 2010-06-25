package org.jostho.zurich.service;

import org.apache.log4j.Logger;
import org.jostho.zurich.dao.UserDao;
import org.jostho.zurich.domain.User;
import org.jostho.zurich.exception.UserNotFoundException;

public class UserServiceImpl implements UserService {
	
	private static Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	private UserDao dao; 
	
	public UserDao getDao() {
		return dao;
	}

	public void setDao(UserDao dao) {
		this.dao = dao;
	}


	public User getUser(int userId) {
		User user = dao.get(userId);
		logger.debug("User : " + user);
		
		// throw exception if user not found
		if(user == null) {			
			throw new UserNotFoundException("User not found: " + userId) ;
		} 
		
		return user; 
	}


}
