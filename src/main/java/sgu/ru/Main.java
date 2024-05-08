package main.java.sgu.ru;

import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String databaseName = "task7";
        String username = "postgres";
        String password = "postgres";
        String ipAddress = "localhost";
        String port = "5432";

        Database db = new Database(databaseName, username, password, ipAddress, port);
        Queries queries = new Queries();

        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = db.connectToDatabase();
            Statement statement = conn.createStatement();
            db.getEmployeesAgeOver20(statement, queries.employeesAgeQuery);
            db.getAverageSalary(statement, queries.averageSalaryQuery);
            db.getEmployeeInfo(statement, queries.employeeInfo);
            conn.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Ошибка загрузки драйвера.");
        }
        catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}