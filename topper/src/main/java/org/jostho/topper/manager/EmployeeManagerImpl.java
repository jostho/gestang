package org.jostho.topper.manager;

import java.util.List;

import org.jostho.topper.dao.EmployeeDao;
import org.jostho.topper.domain.Employee;
import org.jostho.topper.exception.EmployeeNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeManagerImpl implements EmployeeManager {

	private static final String ENF_MESSAGE =  "Employee not found: " ;
	
	private EmployeeDao dao;
	
	public EmployeeDao getDao() {
		return dao;
	}

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	
	@Override
	public Employee getEmployee(int id) {
		Employee employee;
		try {
			employee = dao.get(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EmployeeNotFoundException(ENF_MESSAGE + id, e) ;
		}
		
		return employee ;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		int employeeId = dao.add(employee) ;
		// refresh from dao
		return getEmployee(employeeId) ;
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		int rowsAffected = dao.update(employee) ;
		
		if(rowsAffected == 1) {
			// refresh from dao
			return getEmployee(employee.getId()) ;
		} else {
			throw new EmployeeNotFoundException(ENF_MESSAGE + employee.getId()) ;

		}
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		int rowsAffected = dao.delete(id) ;
		
		if(rowsAffected == 1) {
			return true ;
		} else {
			throw new EmployeeNotFoundException(ENF_MESSAGE + id) ;
		}
	}


}
