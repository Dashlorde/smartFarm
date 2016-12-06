<%-- 
    Document   : doctorSeeLivestock
    Created on : Dec 5, 2016, 1:35:43 PM
    Autdor     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livestock Disease Record Detail</title>
    </head>
    <style>
        table.livstock{
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
        a{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: left;
        }
    </style>
    <body>
        <div>
            <h3>Livestock Detail</h3>
            <table id = "livestock">
                <c:choose>
                    <c:when test="${requestScope.type == 'cow'}">
                        <tr>
                            <th>Cow ID</th>
                            <th>Employee ID</th>
                            <th>Age</th>
                            <th>Weigh</th>
                            <th>Milk Production</th>
                            <th>Estrous Detection</th>
                        </tr>
                        <tr>
                            <td>${requestScope.cow.id}</td>
                            <td>${requestScope.cow.employeeId}</td>
                            <td>${requestScope.cow.age}</td>
                            <td>${requestScope.cow.weight}</td>
                            <td>${requestScope.cow.milkProduction}</td>
                            <td>${requestScope.cow.estrousDetection}</td>
                        </tr>
                    </c:when>
                    <c:when test="${requestScope.type == 'pig'}">
                        <tr>
                            <th>Pig ID</th>
                            <th>Employee ID</th>
                            <th>Age</th>
                            <th>Weigh</th>
                            <th>Gender</th>
                            <th>Estrous Detection</th>
                        </tr>
                        <tr>
                            <td>${requestScope.pig.id}</td>
                            <td>${requestScope.pig.employeeId}</td>
                            <td>${requestScope.pig.age}</td>
                            <td>${requestScope.pig.weight}</td>
                            <td>${requestScope.pig.gender}</td>
                            <td>${requestScope.pig.estrousDetection}</td>
                        </tr>
                    </c:when>
                </c:choose>
            </table>
        </div>
        <div>
            <h3>Disease Detail</h3>
            <table id = "disease">
                <tr>
                    <td>Disease ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Cure</td>
                    <td>Region</td>
                </tr>
                <tr>
                    <td>${requestScope.disease.id}</td>
                    <td>${requestScope.disease.name}</td>
                    <td>${requestScope.disease.description}</td>
                    <td>${requestScope.disease.cure}</td>
                    <td>${requestScope.disease.region}</td>
                </tr>
            </table>
        </div>
        <br/><br/>
        <a href="managediseasehistory.htm" >Back</a><br/>
    </body>
</html>
