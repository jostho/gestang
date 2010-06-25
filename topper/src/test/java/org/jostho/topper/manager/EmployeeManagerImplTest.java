package org.jostho.topper.manager;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.jostho.topper.domain.Employee;
import org.jostho.topper.exception.EmployeeNotFoundException;
import org.jostho.topper.manager.EmployeeManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:topper-servlet.xml", "classpath:topper-business.xml", "classpath:test-topper-datasource.xml"})
public class EmployeeManagerImplTest {

	private static final int VOID_EMPLOYEE_ID = -1;
	
	@Resource(name = "employeeManager")
	private EmployeeManager manager;
	
	@Test
	public void testGetEmployee() {
		Employee employee = manager.getEmployee(1) ;
		Assert.assertNotNull(employee) ;
		Assert.assertEquals("David", employee.getFirstName()) ;
		Assert.assertEquals("david.webb@topper.com", employee.getEmail()) ;
	}

	@Test(expected= EmployeeNotFoundException.class)
	@Ignore("does *not* work with hibernate dao impl")
	public void testGetEmployeeNotFound() {
		Employee employee = manager.getEmployee(VOID_EMPLOYEE_ID) ;
	}
	
	@Test
	public void testGetAllEmployees() {
		List<Employee> employees = manager.getAllEmployees() ;
		Assert.assertNotNull(employees) ;
		Assert.assertTrue(employees.size() > 1) ;
	}
	
	@Test
	public void testAddEmployee() {		
		Employee employee = getDummyEmployee();
		
		Employee newEmployee = manager.addEmployee(employee);
		
		Assert.assertNotNull(newEmployee) ;
		Assert.assertNotNull(newEmployee.getId()) ;
		
	}
	
	@Test
	public void testUpdateEmployee() {
		Employee employee = getDummyEmployee();
		
		Employee addedEmployee = manager.addEmployee(employee);
		// update email only
		addedEmployee.setEmail("robert.ludlum@jostho.org") ;
				
		Employee updatedEmployee = manager.updateEmployee(addedEmployee) ;
		
		Assert.assertEquals(addedEmployee.getId(), updatedEmployee.getId()) ;		
		Assert.assertEquals("robert.ludlum@jostho.org", updatedEmployee.getEmail()) ;
	}
	
	@Test(expected= EmployeeNotFoundException.class)
	@Ignore("does *not* work with hibernate dao impl")
	public void testUpdateEmployeeNotFound() {
		Employee employee = getDummyEmployee();
		employee.setId(VOID_EMPLOYEE_ID) ;
		
		Employee newEmployee = manager.updateEmployee(employee) ;

	}

	@Test
	public void testDeleteEmployee() {
		Employee employee = getDummyEmployee();
		
		Employee addedEmployee = manager.addEmployee(employee);
		int employeeId = addedEmployee.getId() ; 
		boolean status = manager.deleteEmployee(employeeId) ;
		
		Assert.assertTrue(status) ;
		
	}

	@Test(expected= EmployeeNotFoundException.class)
	@Ignore("does *not* work with hibernate dao impl")
	public void testDeleteEmployeeNotFound() {
		boolean status = manager.deleteEmployee(VOID_EMPLOYEE_ID) ;
		
	}

	
	/*
	 * Util method to return a Employee object
	 */
	private static Employee getDummyEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Robert") ;
		employee.setLastName("Ludlum") ;
		employee.setEmail("robert.ludlum@topper.com") ;
		employee.setDesignation("Technical writer") ;
		employee.setDateOfJoining(new Date()) ;
		return employee ;
	}

}
