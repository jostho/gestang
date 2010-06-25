package org.jostho.topper.web;

import java.util.List;

import org.jostho.topper.domain.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class SearchControllerTest extends AbstractControllerTest {
	
	@Test
	public void testHandleRequestInternalForAll() throws Exception {
		
		ModelAndView modelAndView = searchController.handleRequestInternal(request, null) ;
		Assert.assertEquals("results", modelAndView.getViewName()) ;
		
		List<Employee> employees = (List<Employee>) modelAndView.getModel().get("employees") ;
		Assert.assertNotNull(employees) ;
		Assert.assertTrue(employees.size() > 1) ;
		
	}

	@Test
	public void testHandleRequestInternalForOne() throws Exception {
		
		request.addParameter("employeeId", "1") ;
		
		ModelAndView modelAndView = searchController.handleRequestInternal(request, null) ;
		Assert.assertEquals("results", modelAndView.getViewName()) ;
		
		List<Employee> employees = (List<Employee>) modelAndView.getModel().get("employees") ;
		Assert.assertNotNull(employees) ;
		Assert.assertEquals(1, employees.size()) ;
		
	}
}
