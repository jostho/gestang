package org.jostho.topper.web;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * This is the abstract class for all Controller test files. This is excluded 
 * from maven-surefire-plugin run.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:topper-servlet.xml", "classpath:topper-business.xml", "classpath:test-topper-datasource.xml"})
public class AbstractControllerTest {

	@Resource(name = "deleteController")
	protected DeleteController deleteController;
	
	@Resource(name = "editController")
	protected EditController editController;
	
	@Resource(name = "homeController")
	protected HomeController homeController;
	
	@Resource(name = "searchController")
	protected SearchController searchController;

	protected MockHttpServletRequest request;

	@Before
	public void init() {
		request = new MockHttpServletRequest();
	}

}
