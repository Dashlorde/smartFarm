<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livestock Information</title>
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
        
        table{
            width: 100%
        }
        </style>
    </head>
    
    <c:choose>
        <c:when test="${!empty sessionScope.doctor}">
            <jsp:include page="menu2.jsp"/>
        </c:when>
        <c:when test="${!empty sessionScope.employee}">
            <jsp:include page="menu3.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="menu1.jsp"/>
        </c:otherwise>
        
    </c:choose>

    <body>
        <table>
            <tr>
                <th>Id</th>
                <th>Employee_Id</th>
                <th>Age</th>
                <th>Weight</th>
                <th>Gender</th>
                <th>Type</th>
                
            </tr>
            
            <c:forEach var="livestock" items="${requestScope.livestockList}">
                <tr>
                    <td>${livestock.Id}</td>
                    <td>${livestock.EmployeeId}</td>
                    <td>${livestock.age}</td>
                    <td>${livestock.weight}</td>
                    <td>${livestock.gender}</td>
                    <td>${livestock.type}</td>
                    
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
