 CREATE DATABASE employeedb;

 CREATE TABLE employee
 (
 employee_id SERIAL PRIMARY KEY,
 first_name CHARACTER VARYING(30),
 last_name CHARACTER VARYING(30),
 department_id INTEGER,
 job_title CHARACTER VARYING(20)
 gender CHARACTER VARYING(1)
 );

  INSERT INTO employee VALUES (1, 'Maxim', 'Savich', 2, 'manager', 'm')
  INSERT INTO employee VALUES (1, 'John', 'Smith', 1, 'worker', 'm')
  INSERT INTO employee VALUES (1, 'Anna', 'Taylor', 2, 'free-agent', 'w')