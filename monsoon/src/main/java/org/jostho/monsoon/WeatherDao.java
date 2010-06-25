package org.jostho.monsoon;

public interface WeatherDao {

	String get(String city);
	
	boolean update(String city, String forecast);
}
