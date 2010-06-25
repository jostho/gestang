-- topper.sql
-- database: mysql 5.1.32

-- create DB 
CREATE DATABASE topper;

-- give access
GRANT ALL PRIVILEGES ON topper.* TO topper@localhost IDENTIFIED BY 't0pper';

-- connect to topper DB
-- $ mysql -u topper -pt0pper topper 

-- create employees table  
CREATE TABLE employees (
  id INT(6) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(20),
  last_name VARCHAR(20),
  email VARCHAR(60),
  designation VARCHAR(60),
  date_of_joining date
) engine=InnoDB;

-- drop employees table
DROP TABLE employees ;

-- insert data 
INSERT INTO employees (first_name, last_name, email, designation, date_of_joining) 
  VALUES 
  ('David', 'Webb', 'david.webb@topper.com', 'Principal', '2004-01-23'),
  ('Jason', 'Bourne', 'jason.bourne@topper.com', 'Lead software developer', '2005-06-30'),
  ('John', 'Kane', 'john.kane@topper.com', 'Senior software developer', '2006-04-07'),
  ('Charles', 'Briggs', 'charles.briggs@topper.com', 'Software developer', '2007-11-05')  
  ;

-- select all 
SELECT * FROM employees ;

-- select by id
SELECT * FROM employees WHERE id = 1 ;

-- update  
UPDATE employees 
  set first_name='Jason', last_name='Bourne', email='jason.bourne@jostho.org', 
  designation='Lead software developer',  date_of_joining='2005-06-30'
  where id=2 ;

-- delete  
DELETE from employees where id=8 ;  