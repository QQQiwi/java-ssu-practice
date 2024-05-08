
package main.java.sgu.ru;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private String databaseName;
    private String username;
    private String password;
    private String ipAddress;
    private String port;


    public Database(String databaseName, String username, String password,
                    String ipAddress, String port) {
        this.databaseName = databaseName;
        this.username     = username;
        this.password     = password;
        this.ipAddress    = ipAddress;
        this.port         = port;
    }

    public Connection connectToDatabase() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://" +
                                           this.ipAddress + ":" +
                                           this.port + "/" +
                                           this.databaseName,
                                           this.username,
                                           this.password);
    }

    public void getEmployeesAgeOver20(Statement statement, String query) throws java.sql.SQLException {
        ResultSet resultSet = ((Statement) statement).executeQuery(query);
        System.out.println("\n1. Все сотрудники, чей возраст больше 20:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("employeeName"));
        }
    }

    public void getAverageSalary(Statement statement, String query) throws java.sql.SQLException {
        ResultSet resultSet = ((Statement) statement).executeQuery(query);
        System.out.println("\n2. Средняя зарплата по каждому отделу:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("departmentName") + " " + 
                               resultSet.getInt("averageSalary"));
        }
    }

    public void getEmployeeInfo(Statement statement, String query) throws java.sql.SQLException {
        ResultSet resultSet = ((Statement) statement).executeQuery(query);
        System.out.println("\n3. Имя сотрудника, его департамент и локация работы:");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("employeeName") + " " + 
                               resultSet.getString("departmentName") + " " + 
                               resultSet.getString("location"));
        }
    }
}