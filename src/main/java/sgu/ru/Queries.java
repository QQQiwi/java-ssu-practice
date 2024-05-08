package main.java.sgu.ru;

public class Queries {
    public String employeesAgeQuery = "SELECT * FROM employeesAge WHERE age > 20;";

    public String averageSalaryQuery = "SELECT departmentName, Avg(salary) as averageSalary " +
                                       "FROM departmentSalary GROUP BY departmentName;";

    public String employeeInfo = "SELECT employeeName, departmentName, location " +
                                 "FROM departmentEmployee as t1, departmentLocation as t2 " +
                                 "WHERE t1.departmentId = t2.departmentId;";
}