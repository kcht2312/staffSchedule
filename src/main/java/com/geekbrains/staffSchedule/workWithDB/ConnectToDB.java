package com.geekbrains.staffSchedule.workWithDB;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.*;

public class ConnectToDB {

    private static final Logger logger = LogManager.getLogger(ConnectToDB.class.getName());

    protected static Connection connection;
    protected static Statement stmt;

    public static void connect() throws RuntimeException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:employeeDB.db");
            stmt = connection.createStatement();
            logger.info("Соединение с БД установлено");
        } catch (ClassNotFoundException | SQLException e) {
            new RuntimeException("Подключение к базе данных не установлено");
        }

    }

    public static void disconnect() {
        try {
           stmt.close();
       } catch (SQLException e) {
            e.printStackTrace();
            logger.warn(e +  "не удалось закрыть statement");
       }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.warn(e + "не удалось закрыть connection");
        }
    }

}
