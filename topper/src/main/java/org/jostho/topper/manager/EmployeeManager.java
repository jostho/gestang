package org.jostho.topper.manager;

import java.util.List;

import org.jostho.topper.domain.Employee;

public interface EmployeeManager {
	
	Employee getEmployee(int id);
	List<Employee> getAllEmployees();
	Employee addEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	boolean deleteEmployee(int id);
}
