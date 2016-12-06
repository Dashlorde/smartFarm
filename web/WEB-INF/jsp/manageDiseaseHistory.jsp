<%-- 
    Document   : manageDiseaseHistory
    Created on : Dec 4, 2016, 5:51:51 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Disease History</title>
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
        a{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: right;
        }
        h3{
            text-align: center;
        }

    </style>
    <body>
        <div>
            <c:choose>
                <c:when test="${sessionScope.userType=='doctor'}">
                    <jsp:include page="menu2.jsp"/>
                </c:when>
                <c:otherwise>
                    <jsp:include page="menu1.jsp"/>
                </c:otherwise>
            </c:choose>
        </div>

        <div class="form">

            <form action="searchLivestock.htm?type=${requestScope.livestockType}" method="post">
                <input type="text" name="search" />
                search by: 
                <select name="option">
                    <option value="id">id</option>
                    <option value="employeeId">employeeId</option>
                    <option value="age">age</option>

                </select>
                <input type="submit" value="search"/>
            </form>
            <br/><br/>
        </div>

        <div>      
            <h3>Medical Record</h3>
           
            <a href="adddiseasehistory.htm?doctor_id=${sessionScope.Id}" >Add New Disease Record</a><br/><br/>

            <table>
                <tr>
                    <th>Livestock ID</th>
                    <th>Diagnosis Date</th>
                    <th>Disease ID</th>
                    <th>Doctor ID</th>
                    <th>Cured or Not</th>
                    <th>Detail</th>
                    
                </tr>
                <c:forEach var="diseasehistory" items = "${requestScope.diseaseHistoryList}">
                    <tr>
                        <td>${diseasehistory.livestockId}</td>
                        <td>${diseasehistory.diagnosisDate}</td>
                        <td>${diseasehistory.diseaseId}</td>
                        <td>${diseasehistory.doctorId}</td>
                        <td>${diseasehistory.curedOrNot}</td>
                        <td><a href="doctorseelivestockdiseasedetail.htm?livestock_id=${diseasehistory.livestockId}&disease_id=${diseasehistory.diseaseId}" id="detail">detail</a></td>
                    
                    </tr>
                </c:forEach>
            </table>
        </div> 
    </body>
</html>
