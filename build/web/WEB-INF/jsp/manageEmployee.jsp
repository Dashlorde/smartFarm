<%-- 
    Document   : manageEmployee
    Created on : Nov 29, 2016, 10:44:04 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Information</title>
    </head>
    <style>
        table, th, td{
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;
            
        }
        
        th,td{
            padding: 10px 15px;
        }
        
        table{
            width: 100%
        }
         a{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: left;
        }
    </style>
    <body>
       <a href="addemployee.htm" >Add New Employee</a><br/><br/>
       
           <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Category</th>
                <th>Password</th>
                   
            </tr>
            <c:forEach var="employee" items="${requestScope.employeeList}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.phone}</td>
                    <td>${employee.category}</td>
                    <td>${employee.password}</td>
                </tr>
            </c:forEach>
            </table>
       <!--<h1>${requestScope.test}</h1>-->
    </body>
</html>
