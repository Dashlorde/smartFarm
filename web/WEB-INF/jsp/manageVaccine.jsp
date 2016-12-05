<%-- 
    Document   : manageVaccine
    Created on : Dec 3, 2016, 12:01:29 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Information</title>
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
       <a href="addvaccine.htm" >Add New Vaccine</a><br/><br/>
       
           <table>
            <tr>
                <th>Vaccine Id</th>
                <th>Name</th>
                <th>Prevented Disease</th>
                <th>Group</th>
                <th>Vaccine Age</th>
                <th>Immune Period</th>
                   
            </tr>
            <c:forEach var="vaccine" items="${requestScope.vaccineList}">
                <tr>
                    <td>${vaccine.vaccineId}</td>
                    <td>${vaccine.name}</td>
                    <td>${vaccine.diseasePrevent}</td>
                    <td>${vaccine.group}</td>
                    <td>${vaccine.vaccineAge}</td>
                    <td>${vaccine.immunePeriod}</td>
                </tr>
            </c:forEach>
            </table>
       <!--<h1>${requestScope.test}</h1>-->
                    <br/><br/>
           <a href="showAllCow.htm" >Back to Main Menu</a><br/>
    </body>
</html>
