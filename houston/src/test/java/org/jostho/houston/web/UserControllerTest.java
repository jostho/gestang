package org.jostho.houston.web;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:houston-*.xml"})
public class UserControllerTest {

	@Resource(name = "userController")
	private UserController controller;
	
	@Test
	public void testHandleRequest() throws Exception {
		ModelAndView modelAndView = controller.handleRequest(null, null) ;
		Assert.assertEquals("users", modelAndView.getViewName()) ;
		Assert.assertNotNull(modelAndView.getModel().get("usersList")) ;
	}

}
