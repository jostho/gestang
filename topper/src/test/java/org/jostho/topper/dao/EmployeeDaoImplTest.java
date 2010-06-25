package org.jostho.topper.dao;

import java.util.List;

import org.jostho.topper.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.dao.EmptyResultDataAccessException;

public class EmployeeDaoImplTest extends AbstractEmployeeDaoImplTest{

	
	@Test
	public void testGet() {
		Employee employee = employeeDao.get(1) ;
		Assert.assertNotNull(employee) ;
		Assert.assertEquals("David", employee.getFirstName()) ;
		Assert.assertEquals("david.webb@topper.com", employee.getEmail()) ;
		Assert.assertEquals(getJoiningDate(), employee.getDateOfJoining()) ;
	}

	@Test(expected= EmptyResultDataAccessException.class)
	public void testGetNullEmployee() {
		Employee employee = employeeDao.get(VOID_EMPLOYEE_ID) ;
	}

	@Test
	public void testGetAll() {
		List<Employee> employees = employeeDao.getAll() ;
		Assert.assertNotNull(employees) ;
		Assert.assertTrue(employees.size() >= 1) ;
	}

	@Test
	public void testAdd() {
		
		Employee employee = getDummyEmployee() ;
		int generatedId = employeeDao.add(employee);
		
		Assert.assertTrue(generatedId > 0) ;
	}

	@Test
	public void testUpdate() {
		// first add 
		Employee employee = getDummyEmployee() ;
		int generatedId = employeeDao.add(employee);
		Assert.assertTrue(generatedId > 0) ;
		
		// then update		
		employee.setId(generatedId) ;
		employee.setEmail("robert.ludlum@spring.org") ;
		
		int rowsAffected = employeeDao.update(employee);
		Assert.assertEquals(1, rowsAffected) ;
	}

	@Test
	public void testUpdateNullEmployee() {
		Employee employee = getDummyEmployee() ;
		employee.setId(VOID_EMPLOYEE_ID) ;
		
		int rowsAffected = employeeDao.update(employee) ;
		Assert.assertEquals(0, rowsAffected) ;
	}

	@Test
	public void testDelete() {
		// first add 
		Employee employee = getDummyEmployee() ;
		int generatedId = employeeDao.add(employee);		
		Assert.assertTrue(generatedId > 0) ;
		
		// then delete		
		int rowsAffected = employeeDao.delete(generatedId) ;
		Assert.assertEquals(1, rowsAffected) ;
	}

	@Test
	public void testDeleteNullEmployee() {
		int rowsAffected = employeeDao.delete(VOID_EMPLOYEE_ID) ;
		Assert.assertEquals(0, rowsAffected) ;
	}

	
}
