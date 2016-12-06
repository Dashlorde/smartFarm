<%-- 
    Document   : showSensorInfo
    Created on : 2016-12-5, 15:36:40
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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

            .form{
                position: absolute;
                top: 60px;
                width:50%;
            }

            table{
                position: absolute;
                top:100px;
                width: 100%
            }

            table, th, td{
                border: 1px solid black;
                text-align: center;
                border-collapse: collapse;


            }

            th,td{
                padding: 10px 15px;
            }



            #modify,#detail {
                text-decoration: none; 
                display: block;
                color:black;
                text-align: center;
            }


      
        </style>
        
    </head>
    
    <body>
       <div>
            <c:choose>
                <c:when test="${sessionScope.userType=='doctor'}">
                    <jsp:include page="menu2.jsp"/>
                </c:when>
                <c:when test="${sessionScope.userType=='employee'}">
                    <jsp:include page="menu3.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="menu1.jsp"/>
                </c:otherwise>

            </c:choose>
        </div>
        
        <div class="form">

            <form action="showSensorInfo.htm?action=searchSensor" method="post">
                
                search by: 
                <input type="text" name="search" />
                <select name="option">
                    <option value="sensorId">sensor id</option>
                    <option value="livestockId">livestock id</option>
                    <option value="sensorType">sensor type</option>
                    <option value="showAll">show all</option>
                    
                </select>
                <input type="submit" value="search"/>
            </form>
        </div>
            
            <table>
                <tr>
                <th>sensor id</th>
                <th>livestock id</th>
                <th>sensor type</th>                
                </tr>
            
            <c:forEach var="sensor" items="${requestScope.sensorList}">
                 <tr>
                    <td>${sensor.sensorId}</td>
                    <td>${sensor.livestockId}</td>
                    <td>${sensor.sensorType}</td>
                    
                 </tr>
            </c:forEach>
            
            </table>

    </body>
</html>
