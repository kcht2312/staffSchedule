package com.geekbrains.staffSchedule;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.geekbrains.staffSchedule.entity.Employee;
import com.geekbrains.staffSchedule.exception.InvalidArgumentSetException;
import com.geekbrains.staffSchedule.fileIO.ExportToJSON;
import com.geekbrains.staffSchedule.workWithDB.ConnectToDB;
import com.geekbrains.staffSchedule.workWithDB.EmployeeCRUD;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    private static ArrayList<Employee> arrayOfEmployee = new ArrayList<>();

    private static Scanner scanner;

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
                case("importTo"):
                    try {
                        if (values.length < 2 || values.length > 2) {
                            throw new InvalidArgumentSetException();
                        }
                        ExportToJSON.exportArrayOfEmployeeToFile(arrayOfEmployee,values[1]);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }
                case("loadFromDB"):
                    arrayOfEmployee.addAll(EmployeeCRUD.getAllEmployee());
                    break;
                case("showAll"):
                    System.out.println(arrayOfEmployee);
                    break;
                case ("printAll"):
                    EmployeeCRUD.printAll();
                    break;
                case("getCompAverageSal"):
                    EmployeeCRUD.getCompanyAvegrageSalary();
                    break;
                case("getPosAverageSal"):
                    EmployeeCRUD.getPositionAverageSalary();
                    break;
                case("searchByPhone"):
                    try {
                        if (values.length < 2 || values.length > 2) {
                            throw new InvalidArgumentSetException();
                        }
                        EmployeeCRUD.getNameByNumber(values[1]);
                    } catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }
                    break;
                case("addEmp"):
                    try {
                        if (values.length < 5 || values.length > 5) {
                            throw new InvalidArgumentSetException();
                        }
                        EmployeeCRUD.addEmployee(values[1], values[2], Integer.parseInt(values[3]), Float.parseFloat(values[4]));
                    }catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }
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

