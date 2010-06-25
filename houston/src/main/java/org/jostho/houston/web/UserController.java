package org.jostho.houston.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jostho.houston.domain.User;
import org.jostho.houston.manager.UserManager;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

	private static Logger logger = Logger.getLogger(UserController.class);
	
	private UserManager manager;
	
	public UserManager getManager() {
		return manager;
	}

	public void setManager(UserManager manager) {
		this.manager = manager;
	}


	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<User> allUsers = manager.getAllUsers() ;
		logger.debug("You are at users " + allUsers) ;
		
		return new ModelAndView("users", "usersList", allUsers);
	}

}
