package org.jostho.topper.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jostho.topper.manager.EmployeeManager;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class DeleteController extends AbstractController {

	private static Logger logger = Logger.getLogger(DeleteController.class);
	
	private EmployeeManager manager;
	
	public EmployeeManager getManager() {
		return manager;
	}

	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}


	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		int id = ServletRequestUtils.getIntParameter(request, "employeeId", 0);
		
		if(id > 0) {			
			boolean status = manager.deleteEmployee(id) ;
			if(status) {
				logger.debug("Deleted employee " + id) ;	
			}			
		} 		
		
		ModelAndView mav = new ModelAndView("success") ;
		mav.addObject("employee", null);
		return mav ;
	}

}
