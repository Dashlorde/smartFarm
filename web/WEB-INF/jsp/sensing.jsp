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

        ul.menu{
            background-color: #f1f1f1;
            list-style-type:none;
            margin:0;
            padding:0;
            width:100%;
            opacity: 0.8;

        }

        .menu li {
            float: left;
        }

        .menu a{
            display: block;
            color:black;
            text-align:center;
            font-family:Lucida Grande;
            padding: 10px 15px;
            text-decoration: none; 
        }

        .menu a:hover{
            background-color: black;
            color:white;
        }


        table, th, td{
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;

        }

        th,td{
            padding: 10px 15px;
        }

        #top{
            position: absolute;
            top:120px; 
            width:100%;
        }



        table{
            width: 100%;
            margin: 25px 0px;
        }


        .sensor {

            position: absolute;
            top:60px;
        }

        .sensor a{
            text-decoration: none; 
            display: block;
            color:black;

        }
    </style>
    <body> 
        <div>
            <jsp:include page="menu3.jsp"/>
        </div>
        <div class="sensor">
            <a href="startsensing.htm" >Start Sensing</a>
            <a href="endsensing.htm" >End Sensing</a>
        </div>

        <div id="top">
            <div>
                <h3>temperature sensor record</h3>
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



    </body>
</html>
