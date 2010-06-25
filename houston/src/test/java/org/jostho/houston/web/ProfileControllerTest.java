package org.jostho.houston.web;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class ProfileControllerTest {

	@Test
	public void testHandleRequest() throws Exception {
		ProfileController controller = new ProfileController();
		ModelAndView modelAndView = controller.handleRequest(null, null) ;
		Assert.assertEquals("profile", modelAndView.getViewName()) ;
		Assert.assertNotNull(modelAndView.getModel().get("now")) ;
	}

}
