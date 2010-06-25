package org.jostho.topper.dao;

import java.util.List;

import org.jostho.topper.domain.Employee;

public interface EmployeeDao {
	
	/**
	 * Gets a Employee object
	 * @param id
	 * @return the Employee object
	 */
	Employee get(int id);	
	
	/**
	 * Gets all the Employee objects
	 * @return
	 */
	List<Employee> getAll();

	/**
	 * Add a Employee object 
	 * @param employee
	 * @return the id of the Employee object 
	 */
	int add(Employee employee);
	
	/**
	 * Update a Employee object 
	 * @param employee
	 * @return the id of the Employee object, or -1 is Employee not found 
	 */
	int update(Employee employee);

	/**
	 * Delete a Employee object 
	 * @param employee
	 * @return the id of the Employee object, or -1 is Employee not found 
	 */
	int delete(int id);

	
}
