<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

</head>
<body>
<h1>Employees</h1>

<form:form method="POST" action="workWith" modelAttribute="Employees">
    <table>
        <tr>
            <th>EmpID</th>
            <th>ProjectID</th>
            <th>DateFrom</th>
            <th>DateTo</th>
        </tr>
        <c:forEach items="${Employees.employees}" var="employee" varStatus="tagStatus">
            <tr>
                <td><form:input path="employees[${tagStatus.index}].empId" value="${employee.empId}"
                                readonly="true"/></td>
                <td><form:input path="employees[${tagStatus.index}].projectID" value="${employee.projectID}"
                                readonly="true"/></td>
                <td><form:input path="employees[${tagStatus.index}].dateFrom" value="${employee.dateFrom}" readonly="true"/></td>

                <td><form:input path="employees[${tagStatus.index}].dateTo" value="${employee.dateTo}" readonly="true"/></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Save"/>
</form:form>

</body>
</html>