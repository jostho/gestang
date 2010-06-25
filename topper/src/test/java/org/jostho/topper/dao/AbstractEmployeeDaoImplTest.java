package org.jostho.topper.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.jostho.topper.domain.Employee;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * This is the abstract class for all DAO test files. This is excluded 
 * from maven-surefire-plugin run.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:topper-business.xml", "classpath:test-topper-datasource.xml"})
public class AbstractEmployeeDaoImplTest {

	protected static final int VOID_EMPLOYEE_ID = -1;
	
	@Resource(name = "employeeDao")
	protected EmployeeDao employeeDao;
		
	@Resource(name = "hibernateEmployeeDao")
	protected EmployeeDao hibernateEmployeeDao;

	
	/*
	 * Util method to return a Employee object
	 */
	protected Employee getDummyEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("Robert") ;
		employee.setLastName("Ludlum") ;
		employee.setEmail("robert.ludlum@jostho.org") ;
		employee.setDesignation("Technical writer") ;
		employee.setDateOfJoining(new Date()) ;
		return employee ;
	}

	/*
	 * Util method to return a Date object 
	 */
	protected Date getJoiningDate(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd") ;
		Date date = null;
		try {
			date = dateFormat.parse("2004-01-23");
		} catch (ParseException e) {
			// ignore 
		}
		return date ;
	}

}
