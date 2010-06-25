-- monsoon.sql
-- database: mysql 5.0.51a

-- create DB 
CREATE DATABASE monsoon;

-- give access
GRANT ALL PRIVILEGES ON monsoon.* TO monsoon@localhost IDENTIFIED BY 'mons00n';

-- create weather_data table
CREATE TABLE weather_data (
  id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  city_code VARCHAR(3) NOT NULL,
  city_name VARCHAR(30),
  forecast VARCHAR(120),
  last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP 
) engine=InnoDB;

-- drop weather_data table
DROP TABLE weather_data ;

-- insert data 
INSERT INTO weather_data (city_code, city_name, forecast) VALUES 
  ('BLR', 'Bengaluru', 'Cloudy, could be windy in the evening'),
  ('MAA', 'Chennai', 'Hot humid conditions, with chances of shower'),
  ('HYD', 'Hyderabad', 'Hot sunny day with temperature remaining high')
  ;
  
-- select all 
SELECT * FROM weather_data ;

-- select by city_code 
SELECT * FROM weather_data WHERE city_code = 'BLR' ;  