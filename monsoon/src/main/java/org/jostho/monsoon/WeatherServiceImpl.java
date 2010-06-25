package org.jostho.monsoon;

public class WeatherServiceImpl implements WeatherService {

	private WeatherDao dao;
	
	public WeatherDao getDao() {
		return dao;
	}

	public void setDao(WeatherDao dao) {
		this.dao = dao;
	}

	
	/*
	 * Gets the weather at a particular city 
	 */
	public String getWeather(String city) {
		return dao.get(city);
	}

}
