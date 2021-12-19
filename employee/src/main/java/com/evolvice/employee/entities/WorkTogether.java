package com.evolvice.employee.entities;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
public class WorkTogether implements Serializable {

    public WorkTogether() {
    }

    private static final long serialVersionUID = 2L;

    private int projectID;
    private long numOfDay;

    private Employee employee;
    private Employee workWithEmployee;


}
