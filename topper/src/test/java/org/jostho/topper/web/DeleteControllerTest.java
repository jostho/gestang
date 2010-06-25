package org.jostho.topper.web;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class DeleteControllerTest extends AbstractControllerTest {

	@Test
	@Ignore
	public void testHandleRequestInternal() throws Exception {
		
		request.addParameter("employeeId", "88") ;
		
		ModelAndView modelAndView = deleteController.handleRequestInternal(request, null) ;
		Assert.assertEquals("success", modelAndView.getViewName()) ;
		
		
	}
}
