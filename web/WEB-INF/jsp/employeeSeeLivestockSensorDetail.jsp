<%-- 
    Document   : employeeSeeLivestockSensorDetail
    Created on : Dec 6, 2016, 1:52:20 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sensor Detail</title>
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
        <h3>Livestock ID ${requestScope.id} Monitor Detail</h3>
        <div>
            <h4>Temperature Monitor</h4>
            <table>
                <tr>
                    <th>Sensor ID</th>
                    <th>Sensor Time</th>
                    <th>Sensor Read</th>
                </tr> 
                <c:forEach var = "tempsensor" items = "${requestScope.livestocksensorlist}">
                    <tr>
                        <td>${tempsensor.sensorId}</td>
                        <td>${tempsensor.time}</td>
                        <td>${tempsensor.read}</td>
                    </tr>
                </c:forEach>   
            </table>
        </div>
        <div>
            <h4>Milk Monitor</h4>
            <table>
                <tr>
                    <th>Sensor ID</th>
                    <th>Sensor Time</th>
                    <th>Sensor Read</th>
                </tr> 
                <c:forEach var = "milksensor" items = "${requestScope.livestocksensorlistM}">
                    <tr>
                        <td>${milksensor.sensorId}</td>
                        <td>${milksensor.time}</td>
                        <td>${milksensor.read}</td>
                    </tr>
                </c:forEach>   
            </table>
        </div>

        <div>
            <h4>Livestock Weight Monitor</h4>
            <table>
                <tr>
                    <th>Sensor ID</th>
                    <th>Sensor Time</th>
                    <th>Sensor Read</th>
                </tr> 
                <c:forEach var = "weightsensor" items = "${requestScope.livestocksensorlistW}">
                    <tr>
                        <td>${weightsensor.sensorId}</td>
                        <td>${weightsensor.time}</td>
                        <td>${weightsensor.read}</td>
                    </tr>
                </c:forEach>   
            </table>
        </div>

        <div>
            <h4>Acceleration Monitor</h4>
            <table>
                <tr>
                    <th>Sensor ID</th>
                    <th>Sensor Time</th>
                    <th>Sensor Read</th>
                </tr> 
                <c:forEach var = "accesensor" items = "${requestScope.livestocksensorlistA}">
                    <tr>
                        <td>${accesensor.sensorId}</td>
                        <td>${accesensor.time}</td>
                        <td>${accesensor.read}</td>
                    </tr>
                </c:forEach>   
            </table>
        </div>
        <a href="livestockdetail.htm?id=${requestScope.id}&type=${requestScope.livestock_type}" >Back</a><br/>

    </body>
</html>
