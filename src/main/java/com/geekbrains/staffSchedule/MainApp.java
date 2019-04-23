package com.geekbrains.staffSchedule;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.geekbrains.staffSchedule.entity.Employee;
import com.geekbrains.staffSchedule.exception.InvalidArgumentSetException;
import com.geekbrains.staffSchedule.fileIO.WorkWithJson;
import com.geekbrains.staffSchedule.fileIO.WorkWithXml;
import com.geekbrains.staffSchedule.workWithDB.ConnectToDB;
import com.geekbrains.staffSchedule.workWithDB.EmployeeCRUD;
import java.io.IOException;
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
            System.out.println("Список команд: /help");
            System.out.println("Введите команду");

            //Ввод команды
            String cmd = scanner.nextLine();

            //парсинг команды и вызов операции
            String[] values = cmd.split(" ");

            switch (values[0]) {
                case ("help"):
                    System.out.println("Доступные операции(команду и каждый атрибут писать через пробел)\n" +
                            "        /printAll - отобразить все записи из БД \n" +
                            "        /loadFromDB - загрузить записи из БД в list \n" +
                            "        /showAll - отобразить все объекты в list \n" +
                            "        /clearList - удалить все элементы из list\n" +
                            "        /addEmp - добавить работника в БД\n" +
                            "        /expJson - экспортировать записи из БД в файл формата .json \n" +
                            "        /expXml - экспортировать записи из БД в файл формата .xml \n" +
                            "        /impXml - импортировать записи из файла формата .xml в БД \n" +
                            "        /getCompAverageSal - отобразить среднюю зарплату в компании \n" +
                            "        /getPosAverageSal- отобразить среднюю зарплату по должностям \n" +
                            "        /searchByPhone - найти сотрудника по телефону \n" +
                            "        /exit - закрытие программы\n"
                    );
                    break;
                case("loadFromDB"):
                    arrayOfEmployee.addAll(EmployeeCRUD.getAllEmployee());
                    break;
                case("showAll"):
                    System.out.println(arrayOfEmployee);
                    break;
                case("clearList"):
                    arrayOfEmployee.clear();
                    break;
                case ("printAll"):
                    EmployeeCRUD.printAll();
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
                case("expJson"):
                    try {
                        if (values.length < 2 || values.length > 2) {
                            throw new InvalidArgumentSetException();
                        }
                        WorkWithJson.exportArrayOfEmployeeToFile(arrayOfEmployee,values[1]);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case("expXml"):
                    try {
                        if (values.length < 2 || values.length > 2) {
                            throw new InvalidArgumentSetException();
                        }
                        WorkWithXml.exportArrayOfEmployeeToFile(arrayOfEmployee,values[1]);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }
                    break;
                case("impXml"):
                    try {
                        if (values.length < 2 || values.length > 2) {
                            throw new InvalidArgumentSetException();
                        }
                        arrayOfEmployee.addAll(WorkWithXml.importArrayOfEmployeeFromFile(values[1]));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }catch (InvalidArgumentSetException e){
                        e.printStackTrace();
                    }
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

