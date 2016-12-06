<%-- 
    Document   : livestockSensorDetail
    Created on : Dec 5, 2016, 10:56:35 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livestock Sensor Detail</title>
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
        <c:choose>
            <c:when test="${requestScope.type == 'TEMP'}">
                <h4>Temperature Monitor: Livestock ID ${requestScope.id}</h4>
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
            </c:when>
        </c:choose>
        <br/><br/>
        <c:choose>
            <c:when test = "${requestScope.source == 'livestockdetail'}">
                <a href="livestockdetail.htm?id=${requestScope.id}&type=${requestScope.livestock_type}" >Back</a><br/>
            </c:when>
            <c:otherwise>
                <a href="sensing.htm" >Back</a><br/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
