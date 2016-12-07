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
        a.refresh{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: right;
        }
    </style>
    <body>
        <a href="startsensing.htm">Start Sensing</a>
        <a href="endsensing.htm">End Sensing</a>
        <a href="sensing.htm" class = "refresh">Refresh</a><br/>
        <h3>Sensor Monitor</h3>
        <div>
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
        </div>

        <div>
            <h4>Milk Production Monitor</h4>
            <table>
                <tr>
                    <th>Sensor ID</th>
                    <th>Sensor Time</th>
                    <th>Sensor Read</th>
                    <th>Livestock ID</th>
                </tr> 
                <c:forEach var = "milksensor" items = "${requestScope.livestocksensorlistM}">
                    <tr>
                        <td>${milksensor.sensorId}</td>
                        <td>${milksensor.time}</td>
                        <td>${milksensor.read}</td>
                        <td>
                            <a href = "livestockmilksenserdetail.htm?livestock_id=${milksensor.livestockId}">${milksensor.livestockId}</a>
                        </td>
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
                    <th>Livestock ID</th>
                </tr> 
                <c:forEach var = "weightsensor" items = "${requestScope.livestocksensorlistW}">
                    <tr>
                        <td>${weightsensor.sensorId}</td>
                        <td>${weightsensor.time}</td>
                        <td>${weightsensor.read}</td>
                        <td>
                            <a href = "livestockweightsenserdetail.htm?livestock_id=${weightsensor.livestockId}">${weightsensor.livestockId}</a>
                        </td>
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
                    <th>Livestock ID</th>
                </tr> 
                <c:forEach var = "acccesensor" items = "${requestScope.livestocksensorlistA}">
                    <tr>
                        <td>${acccesensor.sensorId}</td>
                        <td>${acccesensor.time}</td>
                        <td>${acccesensor.read}</td>
                        <td>
                            <a href = "livestockaccesenserdetail.htm?livestock_id=${acccesensor.livestockId}">${acccesensor.livestockId}</a>
                        </td>
                    </tr>
                </c:forEach>   
            </table>
        </div>
        <br/><br/>
        <a href="showAllCow.htm" >Back to Main Menu</a><br/>
    </body>
</html>
