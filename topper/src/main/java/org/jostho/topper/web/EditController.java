package org.jostho.topper.web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jostho.topper.domain.Employee;
import org.jostho.topper.manager.EmployeeManager;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class EditController extends SimpleFormController {

	private static Logger logger = Logger.getLogger(EditController.class);
	
	private EmployeeManager manager;
	private CustomDateEditor dateEditor ;

	public EmployeeManager getManager() {
		return manager;
	}

	public void setManager(EmployeeManager manager) {
		this.manager = manager;
	}
	
	public CustomDateEditor getDateEditor() {
		return dateEditor;
	}

	public void setDateEditor(CustomDateEditor dateEditor) {
		this.dateEditor = dateEditor;
	}

	
	/*
	 * To register custom date editor to handle date input from form
	 */
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Date.class, dateEditor) ;
		super.initBinder(request, binder);
	}

	/*
	 * Load the object in form, if in edit mode  
	 */
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		int id = ServletRequestUtils.getIntParameter(request, "employeeId", 0);
		if(id > 0) {
			Employee employee = manager.getEmployee(id) ;
			return employee ;
		} else {
			return new Employee();
		}
	}
	
	/*
	 * Handle the submit action, by calling the appropriate manager method
	 */
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		Employee employee = (Employee) command;
		
		Employee newEmployee = null ;
		
		if(employee.getId() == 0) {
			newEmployee = manager.addEmployee(employee) ;	
		} else {
			newEmployee = manager.updateEmployee(employee) ;
		}
		
		logger.debug("New employee " + newEmployee);
		
	}
}
