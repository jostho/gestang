package org.jostho.monsoon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherDaoImplTest {

	private static final String CONTEXT_XML = "service-context.xml" ;
	private static final String WEATHER_DAO_BEAN = "weatherDao" ;
	
	private ApplicationContext context ;
	
	private WeatherDao dao;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(CONTEXT_XML) ;
		dao = (WeatherDao) context.getBean(WEATHER_DAO_BEAN) ;
	}
	
	@Test
	public void testGetBLR() {
		String weather = dao.get("BLR") ;
		Assert.assertEquals("Cloudy, could be windy in the evening", weather);
	}
	
	@Test
	public void testGetDEL() {
		String weather = dao.get("DEL") ;
		Assert.assertNull(weather);
	}

}
