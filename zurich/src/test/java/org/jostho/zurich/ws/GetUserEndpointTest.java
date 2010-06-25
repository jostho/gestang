package org.jostho.zurich.ws;

import org.jostho.zurich.jaxb.GetUserRQ;
import org.jostho.zurich.jaxb.GetUserRS;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:zurich-*.xml"})
public class GetUserEndpointTest {

	@Resource(name = "getUserEndpoint")
	private GetUserEndpoint endpoint;
	
	@Test
	public void testInvokeInternalObject() throws Exception{
		GetUserRQ request = new GetUserRQ();
		request.setUserId(101) ;
		
		GetUserRS response = (GetUserRS) endpoint.invokeInternal(request) ;
		
		Assert.assertNotNull(response.getUser()) ;
		Assert.assertEquals("Jason", response.getUser().getFirstName()) ;
	}

}
