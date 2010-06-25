-- test-topper.sql
-- database: h2 db (in-memory)

-- create employees table  
CREATE TABLE IF NOT EXISTS 
  employees (
  id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  email VARCHAR(60),
  designation VARCHAR(60),
  date_of_joining date
) ;

-- insert data 
INSERT INTO employees (first_name, last_name, email, designation, date_of_joining) 
  VALUES 
  ('David', 'Webb', 'david.webb@topper.com', 'Principal', '2004-01-23'),
  ('Jason', 'Bourne', 'jason.bourne@topper.com', 'Lead software developer', '2005-06-30')
  ;

