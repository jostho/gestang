package org.jostho.houston.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

	@Test
	public void testHandleRequest() throws Exception {
		HomeController controller = new HomeController();
		ModelAndView modelAndView = controller.handleRequest(null, null) ;
		Assert.assertEquals("home", modelAndView.getViewName()) ;
	}

}
