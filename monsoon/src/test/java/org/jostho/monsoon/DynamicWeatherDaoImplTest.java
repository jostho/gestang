package org.jostho.monsoon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicWeatherDaoImplTest {

	private static final String CONTEXT_XML = "dynamic-service-context.xml" ;
	private static final String WEATHER_SERVICE_PROXY = "weatherServiceProxy" ;
	
	private ApplicationContext context ;

	private WeatherService service;
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(CONTEXT_XML) ;
		service = (WeatherService) context.getBean(WEATHER_SERVICE_PROXY) ;
	}

	
	/*
	 * This is an integration test, hits database
	 */
	@Test
	@Ignore
	public void testGetWeatherInBLR() {
		String weather = service.getWeather("BLR") ;
		Assert.assertEquals("Cloudy, could be windy in the evening", weather);
	}

	
}
