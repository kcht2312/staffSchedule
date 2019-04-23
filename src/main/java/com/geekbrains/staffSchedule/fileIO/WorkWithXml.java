package com.geekbrains.staffSchedule.fileIO;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.geekbrains.staffSchedule.entity.Employee;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class WorkWithXml {

    private static XmlMapper xmlMapper = new XmlMapper();

    public static List<Employee>  importArrayOfEmployeeFromFile(String fileName) throws IOException {
        String xmlFromFile = Files.lines(Paths.get(fileName + ".xml")).collect(Collectors.joining("\n"));
        Employees  employeeIn = xmlMapper.readValue(xmlFromFile, Employees.class);
        return employeeIn.employees;
    }

    public static void exportArrayOfEmployeeToFile (List<Employee> arrayList, String fileName) throws IOException {
        Employees employees = new Employees();
        employees.employees.addAll(arrayList);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(fileName + ".xml"), employees);
    }

    private static class Employees {
        @JacksonXmlProperty(localName = "Employee")
        @JacksonXmlElementWrapper(useWrapping = false)
        public List<Employee> employees;

        public Employees() {
            this.employees = new ArrayList<>();
        }
    }
}
