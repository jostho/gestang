package org.jostho.topper.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest extends AbstractControllerTest {

	@Test
	public void testHandleRequest() throws Exception {
		ModelAndView modelAndView = homeController.handleRequest(request, null) ;
		Assert.assertEquals("home", modelAndView.getViewName()) ;
	}

}
