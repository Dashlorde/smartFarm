<%-- 
    Document   : manageDoctor
    Created on : Dec 2, 2016, 3:12:00 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Information</title>
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
    </style>
    <body>
       <a href="adddoctor.htm" >Add New Doctor</a><br/><br/>
       
           <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Specialty</th>
                <th>Password</th>
                   
            </tr>
            <c:forEach var="doctor" items="${requestScope.doctorList}">
                <tr>
                    <td>${doctor.id}</td>
                    <td>${doctor.name}</td>
                    <td>${doctor.phone}</td>
                    <td>${doctor.speciaty}</td>
                    <td>${doctor.password}</td>
                </tr>
            </c:forEach>
            </table>
       
    </body>
</html>
