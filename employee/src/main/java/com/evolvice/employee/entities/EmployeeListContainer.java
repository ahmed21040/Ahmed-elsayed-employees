package com.evolvice.employee.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class EmployeeListContainer {

    public EmployeeListContainer() {
    }

    private List<Employee> employees;

}
