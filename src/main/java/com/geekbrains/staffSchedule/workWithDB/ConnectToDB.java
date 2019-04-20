package com.geekbrains.staffSchedule.workWithDB;

import java.sql.*;

public class ConnectToDB {

    protected static Connection connection;
    protected static Statement stmt;

    public static void connect() throws RuntimeException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:employeeDB.db");
            stmt = connection.createStatement();
            System.out.println("Соединение c базой данных установлено");
        } catch (ClassNotFoundException | SQLException e) {
            new RuntimeException("Подключение к базе данных не установлено");
        }

    }

    public static void disconnect() {
        try {
           stmt.close();
       } catch (SQLException e) {
            e.printStackTrace();
       }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
