package com.geekbrains.staffSchedule.workWithDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.geekbrains.staffSchedule.workWithDB.ConnectToDB.stmt;

public class EmployeeCRUD {

    //private static PreparedStatement =

    public static void printAll (){
        try {
            ResultSet rs = stmt.executeQuery("SELECT emp.id,name,position,salary, age,phone_number,address FROM \n" +
                    "emp,add_inf WHERE emp.id = add_inf.id;");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                                rs.getString("name") + " " +
                                rs.getString("position") + " " +
                                rs.getFloat("salary")+ " " +
                                rs.getInt("age")+ " " +
                                rs.getString("phone_number") + " " +
                                rs.getString("address")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
