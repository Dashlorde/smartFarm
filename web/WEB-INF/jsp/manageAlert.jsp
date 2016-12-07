<%-- 
    Document   : manageAlert
    Created on : Dec 6, 2016, 7:04:39 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Alert</title>
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
            text-align: right;
        }
    </style>
    <body>
        <h3>Alert List</h3>
        <a href="showAllCow.htm">Back</a><br/>
        <table>
            <tr>
                <th>Sensor Id</th>
                <th>Time</th>
                <th>Possible Event</th>
                <th>Sensor Type</th>
                <th>Livestock ID</th>
                   
            </tr>
            <c:forEach var="alert" items="${requestScope.alertList}">
                <tr>
                    <td>${alert.sensorId}</td>
                    <td>${alert.time}</td>
                    <td>${alert.possibleEvent}</td>
                    <td>${alert.sensorType}</td>
                    <td>${alert.livestockId}</td>
                </tr>
            </c:forEach>
            </table>
       
       <!--<h1>${requestScope.test}</h1>-->
    </body>
</html>
