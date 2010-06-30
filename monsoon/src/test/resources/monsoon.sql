-- monsoon.sql
-- database: h2 db (in-memory)

-- create weather_data table
CREATE TABLE IF NOT EXISTS 
weather_data (
  id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  city_code VARCHAR(3) NOT NULL,
  city_name VARCHAR(30),
  forecast VARCHAR(120),
  last_updated TIMESTAMP  
) ;

-- insert data 
INSERT INTO weather_data (city_code, city_name, forecast) VALUES 
  ('BLR', 'Bengaluru', 'Cloudy, could be windy in the evening'),
  ('MAA', 'Chennai', 'Hot humid conditions, with chances of shower'),
  ('HYD', 'Hyderabad', 'Hot sunny day with temperature remaining high')
  ;
  
