package org.jostho.monsoon;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

/*
 * A DAO impl backed by a real database 
 */
public class DynamicWeatherDaoImpl implements WeatherDao {

	protected static final String SELECT_SQL = 
		"SELECT * FROM weather_data WHERE city_code = ? " ;
	protected static final String FORECAST = "forecast" ;
	
	protected JdbcTemplate jdbcTemplate;

	
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource) ;
	}

	public String get(String city) {
		Object[] args = new Object[] {city} ;
		Map resultMap = jdbcTemplate.queryForMap(SELECT_SQL, args);
		return (String) resultMap.get(FORECAST) ;		
	}

	public boolean update(String city, String forecast) {
		// TODO Auto-generated method stub
		return false;
	}

}
