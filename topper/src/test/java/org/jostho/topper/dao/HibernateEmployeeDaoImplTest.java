package org.jostho.topper.dao;

import java.util.List;

import org.jostho.topper.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

public class HibernateEmployeeDaoImplTest extends AbstractEmployeeDaoImplTest{

	@Test
	public void testGet() {
		Employee employee = hibernateEmployeeDao.get(1) ;
		Assert.assertNotNull(employee) ;
		Assert.assertEquals("David", employee.getFirstName()) ;
		Assert.assertEquals("david.webb@topper.com", employee.getEmail()) ;
		Assert.assertEquals(getJoiningDate(), employee.getDateOfJoining()) ;
	}

	@Test
	public void testGetNullEmployee() {
		Employee employee = hibernateEmployeeDao.get(VOID_EMPLOYEE_ID) ;
		Assert.assertNull(employee) ;
	}

	@Test
	public void testGetAll() {
		List<Employee> employees = hibernateEmployeeDao.getAll() ;
		Assert.assertNotNull(employees) ;
		Assert.assertTrue(employees.size() >= 1) ;
	}
	
	@Test
	public void testAdd() {
		
		Employee employee = getDummyEmployee() ;
		int generatedId = hibernateEmployeeDao.add(employee);
		
		Assert.assertTrue(generatedId > 0) ;
	}

	@Test
	public void testDelete() {
		// first add 
		Employee employee = getDummyEmployee() ;
		int generatedId = hibernateEmployeeDao.add(employee);		
		Assert.assertTrue(generatedId > 0) ;
		
		// then delete		
		int rowsAffected = hibernateEmployeeDao.delete(generatedId) ;
		Assert.assertEquals(1, rowsAffected) ;
	}


	@Test
	public void testUpdate() {
		// first add 
		Employee employee = getDummyEmployee() ;
		int generatedId = hibernateEmployeeDao.add(employee);
		Assert.assertTrue(generatedId > 0) ;
		
		// then update		
		employee.setId(generatedId) ;
		employee.setEmail("robert.ludlum@hibernate.org") ;
		
		int rowsAffected = hibernateEmployeeDao.update(employee);
		Assert.assertEquals(1, rowsAffected) ;
	}	
	
}
