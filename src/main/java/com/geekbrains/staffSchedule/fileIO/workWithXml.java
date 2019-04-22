package com.geekbrains.staffSchedule.fileIO;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.geekbrains.staffSchedule.entity.Employee;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;



public class workWithXml {

    private static XmlMapper xmlMapper = new XmlMapper();

    public static ArrayList<Employee>  importArrayOfEmployeeFromFile(String fileName) throws IOException {
        ArrayList<Employee> arrayList = new ArrayList<>();
        String xmlFromFile = Files.lines(Paths.get(fileName + ".xml")).collect(Collectors.joining("\n"));
            Employee employeeIn = xmlMapper.readValue(xmlFromFile, Employee.class);
            arrayList.add(employeeIn);
        return arrayList;
    }

    public static void exportArrayOfEmployeeToFile (ArrayList<Employee> arrayList, String fileName) throws IOException {
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try
        {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".xml",true), "UTF-8"));
        for (Employee employee : arrayList) {
            String xmlEmployee = xmlMapper.writeValueAsString(employee);
            bw.write(xmlEmployee);
            bw.newLine();
        }
            bw.flush();
            bw.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
