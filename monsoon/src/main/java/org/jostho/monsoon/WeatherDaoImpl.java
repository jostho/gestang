package org.jostho.monsoon;

import java.util.Map;

/*
 * A simple DAO impl backed by a HashMap 
 */
public class WeatherDaoImpl implements WeatherDao {
	
	private Map<String, String> weatherData;
	
	public Map<String, String> getWeatherData() {
		return weatherData;
	}

	public void setWeatherData(Map<String, String> weatherData) {
		this.weatherData = weatherData;
	}

	
	/*
	 * Gets the weather from a static source 
	 */
	public String get(String city) {
		return weatherData.get(city);
	}

	/*
	 * Updates the weather to a static source 
	 */
	public boolean update(String city, String forecast) {
		// NOTE: no-op
		return false;
	}


}
