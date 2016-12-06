<%-- 
    Document   : sensing
    Created on : 2016-12-4, 21:37:05
    Author     : jingli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sensor</title>
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
        h3{
            text-align: center;
        }
         a{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: left;
        }
    </style>
    <body>
        <a href="startsensing.htm">Start Sensing</a>
        <a href="endsensing.htm">End Sensing</a>
        <h3>Sensor Monitor</h3>
        <h4>Temperature Monitor</h4>
        <table>
            <tr>
                <th>Sensor ID</th>
                <th>Sensor Time</th>
                <th>Sensor Read</th>
                <th>Livestock ID</th>
            </tr> 
             <c:forEach var = "tempsensor" items = "${requestScope.livestocksensorlist}">
                <tr>
                    <td>${tempsensor.sensorId}</td>
                    <td>${tempsensor.time}</td>
                    <td>${tempsensor.read}</td>
                    <td>
                        <a href = "livestocktempsenserdetail.htm?livestock_id=${tempsensor.livestockId}">${tempsensor.livestockId}</a>
                    </td>
                </tr>
            </c:forEach>   
        </table>
        <br/><br/>
        <a href="showAllCow.htm" >Back to Main Menu</a><br/>
    </body>
</html>
