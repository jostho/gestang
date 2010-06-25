package org.jostho.zurich.service;

import javax.annotation.Resource;

import org.jostho.zurich.domain.User;
import org.jostho.zurich.exception.UserNotFoundException;
import org.junit.Assert ;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:zurich-*.xml"})
public class UserServiceImplTest {

	@Resource(name = "userService")
	private UserService service;
	
	@Test
	public void testGetUser() {
		User user = service.getUser(101) ;
		Assert.assertNotNull(user) ;
	}

	
	@Test
	public void testGetUserNotFound() {
		try {
			User user = service.getUser(99) ;
		} catch (UserNotFoundException e) {
			// expect UNF exception
			Assert.assertNotNull(e);
		}
	}
}
