package com.evolvice.employee.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class Employee  implements Serializable {

    public Employee() {
    }

    private static final long serialVersionUID = 1L;
    private int empId;
    private int projectID;

    private String dateFrom;
    private String dateTo;
}
