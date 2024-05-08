CREATE TABLE employeesAge(
	id SERIAL PRIMARY KEY, 
	employeeName VARCHAR(100) NOT NULL, 
	age INTEGER NOT NULL
);
INSERT INTO employeesAge (employeeName, age) 
VALUES ('Кирилл', 18), ('Саша', 20), ('Катя', 25);


CREATE TABLE departmentSalary(
	id SERIAL PRIMARY KEY, 
	employeeName VARCHAR(100) NOT NULL, 
	departmentName VARCHAR(100) NOT NULL, 
	salary INTEGER NOT NULL
);
INSERT INTO departmentSalary (employeeName, departmentName, salary) 
VALUES ('Кирилл', 'IT', 30000), ('Иван', 'IT', 20000), ('Маша', 'HR', 40000);


CREATE TABLE departmentLocation(
	departmentId SERIAL PRIMARY KEY, 
	departmentName VARCHAR(100) NOT NULL,
	location VARCHAR(100) NOT NULL
);
INSERT INTO departmentLocation (departmentName, location) 
VALUES ('IT', 'Саратов'), ('HR', 'Москва');


CREATE TABLE departmentEmployee(
	id SERIAL PRIMARY KEY, 
	employeeName VARCHAR(100) NOT NULL,
	departmentId INTEGER NOT NULL REFERENCES departmentLocation(departmentId)
);
INSERT INTO departmentEmployee (employeeName, departmentId) 
VALUES ('Кирилл', 1), ('Иван', 1), ('Маша', 2);
