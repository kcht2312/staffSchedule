package com.geekbrains.staffSchedule;


import com.geekbrains.staffSchedule.workWithDB.ConnectToDB;
import com.geekbrains.staffSchedule.workWithDB.EmployeeCRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {

    private static Scanner scanner;
    protected static Connection connection;
    protected static Statement stmt;


    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        try {
            ConnectToDB.connect();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        //Старт консольного приложения
        while (true) {
            System.out.println("Введите команду");

            //Ввод команды
            String cmd = scanner.nextLine();

            //парсинг команды и вызов операции
            String[] values = cmd.split(" ");

            switch (values[0]) {
                case ("help"):
                    System.out.println("Доступные операции(команду и каждый атрибут писать через пробел)\n" +
                            "        printAll;\n" +
                            "        searchByCost(min и max значения)\n" +
                            "        clearTable\n" +
                            "        exit\n"
                    );
                    break;
                case ("printAll"):
                    EmployeeCRUD.printAll();
                    break;
                case ("exit"):
                    ConnectToDB.disconnect();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Incorrect command");
            }
        }

    }

}

