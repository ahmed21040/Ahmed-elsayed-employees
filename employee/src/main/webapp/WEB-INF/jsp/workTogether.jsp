<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>

</head>
<body>
<h1>Pair of employees that have worked as a team for the longest time</h1>
<h3>Number Of day working together ${workTogether.numOfDay}</h3>

<table>
    <tr>
        <th>EmpID</th>
        <th>ProjectID</th>
        <th>DateFrom</th>
        <th>DateTo</th>
    </tr>
    <tr>
        <td>${workTogether.employee.empId}</td>
        <td>${workTogether.employee.projectID}</td>
        <td>${workTogether.employee.dateFrom}</td>
        <td>${workTogether.employee.dateTo}</td>
    </tr>
    <tr>
        <td>${workTogether.workWithEmployee.empId}</td>
        <td>${workTogether.workWithEmployee.projectID}</td>
        <td>${workTogether.workWithEmployee.dateFrom}</td>
        <td>${workTogether.workWithEmployee.dateTo}</td>
    </tr>

</table>
</body>
</html>

</body>
</html>