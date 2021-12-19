package com.evolvice.employee.services;

import com.evolvice.employee.entities.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UploadService {


    public List<Employee> extractFileContent(MultipartFile file) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        InputStream inputStream = file.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        List<Employee> employees = br.lines().map(line -> {
            String[] element = line.split(",");
            if (element.length == 4) {

                return Employee.builder().empId(Integer.parseInt(element[0].trim()))
                        .projectID(Integer.parseInt(element[1].trim()))
                        .dateFrom(element[2].trim())
                        .dateTo(element[3].trim()).build();
            } else {
                return null;
            }

        }).collect(Collectors.toList());

        return employees;
    }
}
