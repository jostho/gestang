package org.jostho.houston.manager;

import java.util.List;

import javax.annotation.Resource;

import org.jostho.houston.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:houston-*.xml"})
public class UserManagerImplTest {

	@Resource(name = "userManager")
	private UserManager manager;
	
	@Test
	public void testAdd() {
		try {
			manager.add(new User());
			Assert.fail("UOE exception should be thrown");
		} catch (UnsupportedOperationException e) {
			// works as expected
		}
	}

	@Test
	public void testGet() {
		User user = manager.getUser(101) ;
		Assert.assertNotNull(user) ;
		Assert.assertEquals("Jason Charles Bourne", user.getName()) ;
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = manager.getAllUsers() ;
		Assert.assertNotNull(users) ;
		Assert.assertEquals(3, users.size()) ;
	}
}
