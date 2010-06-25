package org.jostho.topper.web;

import org.jostho.topper.domain.Employee;
import org.junit.Assert;
import org.junit.Test;

public class EditControllerTest extends AbstractControllerTest {
	
	@Test
	public void testFormBackingObject() throws Exception {
		
		Employee employee = null;
		
		employee = (Employee) editController.formBackingObject(request) ;
		Assert.assertNull(employee.getFirstName()) ;
		
		request.addParameter("employeeId", "1") ;
		employee = (Employee) editController.formBackingObject(request) ;
		Assert.assertNotNull(employee.getFirstName()) ;
		Assert.assertEquals("David", employee.getFirstName()) ;
	}

}
