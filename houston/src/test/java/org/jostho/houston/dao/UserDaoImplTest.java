package org.jostho.houston.dao;

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
public class UserDaoImplTest {

	@Resource(name = "userDao")
	private UserDao dao;
	
	@Test
	public void testAdd() {
		try {
			dao.add(new User());
			Assert.fail("UOE exception should be thrown");
		} catch (UnsupportedOperationException e) {
			// works as expected
		}	
		
	}

	@Test
	public void testGet() {
		User user = dao.get(101) ;
		Assert.assertNotNull(user) ;
		Assert.assertEquals("Jason Charles Bourne", user.getName()) ;
	}

	@Test
	public void testGetAll() {
		List<User> users = dao.getAll() ;
		Assert.assertNotNull(users) ;
		Assert.assertEquals(3, users.size()) ;
	}
}
