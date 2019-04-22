package com.geekbrains.staffSchedule.fileIO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.geekbrains.staffSchedule.entity.Employee;

import java.io.*;
import java.util.ArrayList;

public class workWithJson {
    public static void exportArrayOfEmployeeToFile(ArrayList<Employee> arrayList, String fileName) throws JsonProcessingException {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName + ".json", true), "UTF-8"));
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            for (Employee employee : arrayList) {
                String jsonEmployee = mapper.writeValueAsString(employee);
                bw.write(jsonEmployee);
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

