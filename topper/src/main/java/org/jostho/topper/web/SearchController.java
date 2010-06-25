package org.jostho.topper.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jostho.topper.domain.Employee;
import org.jostho.topper.manager.EmployeeManager;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class SearchController extends AbstractController {

	private static Logger logger = Logger.getLogger(SearchController.class);
	
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
		List<Employee> employees = null ;
		
		if(id > 0) {
			logger.debug("Getting employee by id: " + id) ;
			Employee employee = manager.getEmployee(id) ;
			employees = new ArrayList<Employee>();
			employees.add(employee);
		} else { 
			employees = manager.getAllEmployees() ;
		}
		
		
		logger.debug("Number of employees is " + employees.size()) ;
		
		ModelAndView mav = new ModelAndView("results") ;
		mav.addObject("employees", employees);
		return mav ;
	}

}
