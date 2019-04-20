package com.geekbrains.staffSchedule.workWithDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.geekbrains.staffSchedule.entity.AdditionalInformation;
import com.geekbrains.staffSchedule.entity.Employee;

import static com.geekbrains.staffSchedule.workWithDB.ConnectToDB.stmt;

public class EmployeeCRUD {

    static PreparedStatement addEmp;
    static PreparedStatement searchByPhone;

    static {
        try {
            addEmp = ConnectToDB.connection.prepareStatement("INSERT INTO emp (name, position, age, salary) VALUES (?,?,?,?)");
            searchByPhone = ConnectToDB.connection.prepareStatement("SELECT name FROM emp WHERE id = (SELECT id FROM add_Inf WHERE phone_number = ?)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //метод для импорта работников из базы в list
    public static ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> internalArrayOfEmployee = new ArrayList<>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT emp.id,name,position,salary, age,phone_number,address FROM \n" +
                    "emp,add_inf WHERE emp.id = add_inf.id;");
            while (rs.next()) {
                Employee employee = new Employee();
                AdditionalInformation additionalInformation = new AdditionalInformation();
                employee.setID(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPosition(rs.getString("position"));
                employee.setSalary(rs.getFloat("salary"));
                employee.setAge(rs.getInt("age"));
                additionalInformation.setID(rs.getInt("id"));
                additionalInformation.setPhoneNumber(rs.getString("phone_number"));
                additionalInformation.setAddress(rs.getString("address"));
                employee.setAddInform(additionalInformation);
                internalArrayOfEmployee.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internalArrayOfEmployee;
    }

    //метод для добавления работника в БД
    public static void addEmployee(String name, String position, int age, float salary) {
        try {
            addEmp.setString(1, name);
            addEmp.setString(2, position);
            addEmp.setInt(3, age);
            addEmp.setFloat(4, salary);
            addEmp.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getNameByNumber(String phoneNumber){
        try{
            searchByPhone.setString(1, phoneNumber);
            ResultSet rs = searchByPhone.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void printAll() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT emp.id,name,position,salary, age,phone_number,address FROM \n" +
                    "emp,add_inf WHERE emp.id = add_inf.id;");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("position") + " " +
                                rs.getFloat("salary") + " " +
                                rs.getInt("age") + " " +
                                rs.getString("phone_number") + " " +
                                rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getCompanyAvegrageSalary() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT avg(salary)AS average_salary FROM emp;");

            System.out.println(rs.getInt("average_salary"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getPositionAverageSalary() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT position, avg(salary)AS average_salary FROM emp GROUP BY position;");
            while (rs.next()) {
                System.out.println(rs.getString("position") + " " + rs.getInt("average_salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
