package org.jostho.monsoon;

import org.jostho.monsoon.WeatherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WeatherServiceImplTest {

	private static final String CONTEXT_XML = "service-context.xml" ;
	private static final String WEATHER_SERVICE_BEAN = "weatherService" ;
	
	private ApplicationContext context ;
	
	private WeatherService service;
	
	
	@Before
	public void init(){
		context = new ClassPathXmlApplicationContext(CONTEXT_XML) ;
		service = (WeatherService) context.getBean(WEATHER_SERVICE_BEAN) ;
	}
	
	
	@Test
	public void testGetWeatherInBLR() {
		String weather = service.getWeather("BLR") ;
		Assert.assertEquals("Cloudy, could be windy in the evening", weather);
	}

	@Test
	public void testGetWeatherInDEL() {
		String weather = service.getWeather("DEL") ;
		Assert.assertNull(weather);
	}

}
