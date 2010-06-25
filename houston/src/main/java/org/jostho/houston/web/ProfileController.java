package org.jostho.houston.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ProfileController implements Controller {

	private static Logger logger = Logger.getLogger(ProfileController.class);
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Date now = new Date();
		logger.debug("You are at profile " + now ) ;
		return new ModelAndView("profile", "now", now);
	}

}
