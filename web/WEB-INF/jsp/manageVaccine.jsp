<%-- 
    Document   : manageVaccine
    Created on : Dec 3, 2016, 12:01:29 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vaccine Information</title>
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
            width: 100%;
            position:absolute;
            top:60px;
            
        }
        
        .add{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: center;
            font-family:Lucida Grande;
            position: fixed;
            bottom: 100px;
            padding: 10px 15px;
            margin:auto;
            border: solid 1px black;
        }
        
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
            
    </style>
    <body>
        <div>
            <jsp:include page="menu3.jsp"/>
        </div>
       
       
           <table>
            <tr>
                <th>Vaccine Id</th>
                <th>Name</th>
                <th>Prevented Disease</th>
                <th>Group</th>
                <th>Vaccine Age</th>
                <th>Immune Period</th>
                   
            </tr>
            <c:forEach var="vaccine" items="${requestScope.vaccineList}">
                <tr>
                    <td>${vaccine.vaccineId}</td>
                    <td>${vaccine.name}</td>
                    <td>${vaccine.diseasePrevent}</td>
                    <td>${vaccine.group}</td>
                    <td>${vaccine.vaccineAge}</td>
                    <td>${vaccine.immunePeriod}</td>
                </tr>
            </c:forEach>
            </table>
       <!--<h1>${requestScope.test}</h1>-->
                    <br/><br/>
         <a href="addvaccine.htm" class="add">Add New Vaccine</a><br/><br/>  
    </body>
</html>
