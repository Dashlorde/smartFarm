<%-- 
    Document   : manageDisease
    Created on : Dec 4, 2016, 8:28:48 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disease Information</title>
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
        <h3>Disease List</h3>
        <a href="adddisease.htm">Add New Disease</a>

        <table>
            <tr>
                <th>Disease ID</th>
                <th>Name</th>
                <th>Description</th>
                <th>Cure</th>
                <th>Region</th>
            </tr>
            <c:forEach var = "disease" items = "${requestScope.diseaseList}">
                <tr>
                    <td>${disease.id}</td>
                    <td>${disease.name}</td>
                    <td>${disease.description}</td>
                    <td>${disease.cure}</td>
                    <td>${disease.region}</td>
                </tr>
            </c:forEach>    
        </table>
        
        <br/><br/>
        <a href="managediseasehistory.htm?">Back</a><br/>
    </body>
</html>
