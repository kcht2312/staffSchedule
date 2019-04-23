package com.geekbrains.staffSchedule.fileIO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.geekbrains.staffSchedule.entity.Employee;

import java.io.*;
import java.util.ArrayList;

public class WorkWithJson {
    public static void exportArrayOfEmployeeToFile(ArrayList<Employee> arrayList, String fileName) throws JsonProcessingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File(fileName + ".json"), arrayList);
    }
}

