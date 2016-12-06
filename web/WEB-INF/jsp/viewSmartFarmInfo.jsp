<%-- 
    Document   : viewSmartFarmInfo
    Created on : 2016-12-5, 23:54:49
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>smart farm information</title>
        <style>
            table{
                
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


        </style>
    </head>
    <body>
        <div>
            <h2>livestock average age is ${requestScope.averageAge}</h2>
            <h2>this farm has ${requestScope.cowNum} cows and ${requestScope.pigNum} pigs</h2>
            
        </div>
        
        <div>
            <h3>Youngest Cow Information</h3>
            <table>
                <tr>
                    <th>Cow_Id</th>
                    <th>Employee_Id</th>
                    <th>Age</th>
                    <th>Weight</th>
                    <th>Gender</th>              
                </tr>

                <c:forEach var="cow" items="${requestScope.youngCowList}">
                    <tr>
                        <td>${cow.id}</td>
                        <td>${cow.employeeId}</td>
                        <td>${cow.age}</td>
                        <td>${cow.weight}</td>
                        <td>${cow.gender}</td>
                    </tr>
                </c:forEach>

            </table>
        </div>

        <div>
            <h3>Oldest Cow Information</h3>
            <table>
                <tr>
                    <th>Cow_Id</th>
                    <th>Employee_Id</th>
                    <th>Age</th>
                    <th>Weight</th>
                    <th>Gender</th>              
                </tr>

                <c:forEach var="cow" items="${requestScope.oldCowList}">
                    <tr>
                        <td>${cow.id}</td>
                        <td>${cow.employeeId}</td>
                        <td>${cow.age}</td>
                        <td>${cow.weight}</td>
                        <td>${cow.gender}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <h3>Youngest Pig Information</h3>
            <table>
                <tr>
                    <th>Pig_Id</th>
                    <th>Employee_Id</th>
                    <th>Age</th>
                    <th>Weight</th>
                    <th>Gender</th>              
                </tr>

                <c:forEach var="pig" items="${requestScope.youngPigList}">
                    <tr>
                        <td>${pig.id}</td>
                        <td>${pig.employeeId}</td>
                        <td>${pig.age}</td>
                        <td>${pig.weight}</td>
                        <td>${pig.gender}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <h3>Oldest Pig Information</h3>
            <table>
                <tr>
                    <th>Pig_Id</th>
                    <th>Employee_Id</th>
                    <th>Age</th>
                    <th>Weight</th>
                    <th>Gender</th>              
                </tr>

                <c:forEach var="pig" items="${requestScope.oldPigList}">
                    <tr>
                        <td>${pig.id}</td>
                        <td>${pig.employeeId}</td>
                        <td>${pig.age}</td>
                        <td>${pig.weight}</td>
                        <td>${pig.gender}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>       
    </body>
</html>
