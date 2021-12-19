package com.evolvice.employee.services;

import com.evolvice.employee.entities.Employee;
import com.evolvice.employee.entities.WorkTogether;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WorkWithService {

    public WorkTogether getLongestTime(List<Employee> employees) throws ParseException {

        WorkTogether workTogether = null;

        for (int i = 0; i < employees.size(); i++) {

            Employee employee = employees.get(i);

            Date employeeDateTo = getDateFromString(employee.getDateTo());

            Date employeeDateFrom = getDateFromString(employee.getDateFrom());

            for (int j = i + 1; j < employees.size(); j++) {
                Employee employeeWorkWith = employees.get(j);

                if (employeeWorkWith.getProjectID() == employee.getProjectID()) {
                    Date employeeWorkWithDateTo = getDateFromString(employeeWorkWith.getDateTo());

                    Date employeeWorkWithDateFrom = getDateFromString(employeeWorkWith.getDateFrom());

                    if ((employeeDateFrom.after(employeeWorkWithDateFrom) || employeeDateFrom.equals(employeeWorkWithDateFrom))
                            && (employeeDateTo.before(employeeWorkWithDateTo) || employeeDateTo.equals(employeeWorkWithDateTo))) {

                        long differenceDates = getNumberOfDay(employeeDateFrom, employeeDateTo);

                        workTogether = getWorkTogetherLongestTime(employee, employeeWorkWith, workTogether, differenceDates);

                    } else if ((employeeWorkWithDateFrom.after(employeeDateFrom) || employeeWorkWithDateFrom.equals(employeeDateFrom))
                            && (employeeWorkWithDateTo.before(employeeDateTo) || employeeWorkWithDateTo.equals(employeeDateTo))) {

                        long differenceDates = getNumberOfDay(employeeWorkWithDateFrom, employeeWorkWithDateTo);

                        workTogether = getWorkTogetherLongestTime(employee, employeeWorkWith, workTogether, differenceDates);

                    } else if (((employeeDateFrom.after(employeeWorkWithDateFrom) && employeeDateFrom.before(employeeWorkWithDateTo)) || employeeDateFrom.equals(employeeWorkWithDateFrom))
                            && (employeeWorkWithDateTo.before(employeeDateTo) || employeeWorkWithDateTo.equals(employeeDateTo))) {

                        long differenceDates = getNumberOfDay(employeeDateFrom, employeeWorkWithDateTo);

                        workTogether = getWorkTogetherLongestTime(employee, employeeWorkWith, workTogether, differenceDates);

                    } else if (((employeeWorkWithDateFrom.after(employeeDateFrom) && employeeWorkWithDateFrom.before(employeeDateTo)) || employeeWorkWithDateFrom.equals(employeeDateFrom))
                            && (employeeDateTo.before(employeeWorkWithDateTo) || employeeDateTo.equals(employeeWorkWithDateTo))) {

                        long differenceDates = getNumberOfDay(employeeWorkWithDateFrom, employeeDateTo);

                        workTogether = getWorkTogetherLongestTime(employee, employeeWorkWith, workTogether, differenceDates);

                    }

                }

            }
        }
        return workTogether;
    }

    private WorkTogether getWorkTogetherLongestTime(Employee employee, Employee employeeWorkWith,
                                                    WorkTogether workTogether, long differenceDates) {
        if (workTogether == null) {
            return WorkTogether.builder().employee(employee).workWithEmployee(employeeWorkWith)
                    .projectID(employee.getProjectID()).numOfDay(differenceDates).build();
        } else if (workTogether.getNumOfDay() >= differenceDates) {
            return workTogether;
        } else {
            return WorkTogether.builder().employee(employee).workWithEmployee(employeeWorkWith)
                    .projectID(employee.getProjectID()).numOfDay(differenceDates).build();
        }

    }

    private Date getDateFromString(String dateStr) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!dateStr.equals("NULL")) {
            return dateFormat.parse(dateStr);
        } else {
            return new Date();
        }
    }

    private long getNumberOfDay(Date dateFrom, Date dateTo) {
        long difference = dateTo.getTime() - dateFrom.getTime();
        return difference / (24 * 60 * 60 * 1000);
    }
}
