package org.jostho.zurich.dao;

import java.util.List;

import javax.annotation.Resource;

import org.jostho.zurich.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:zurich-*.xml"})
public class UserDaoImplTest {

	@Resource(name = "userDao")
	private UserDao dao;


	@Test
	public void testGet() {
		User user = dao.get(101) ;
		Assert.assertNotNull(user) ;
		Assert.assertEquals("Jason", user.getFirstName()) ;
	}

	@Test
	public void testGetUserNotFound() {
		User user = dao.get(99) ;
		Assert.assertNull(user) ;
	}
	
	@Test
	public void testGetAll() {
		List<User> users = dao.getAll() ;
		Assert.assertNotNull(users) ;
		Assert.assertEquals(3, users.size()) ;
	}
}
