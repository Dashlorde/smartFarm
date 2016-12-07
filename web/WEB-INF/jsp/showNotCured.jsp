<%-- 
    Document   : showNotCured
    Created on : 2016-12-5, 11:38:08
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>show not cured</title>
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


            <form action="showNotCured.htm?type=${requestScope.livestockType}" method="post">

                search by: 
                <select name="option">
                    <option value="showLivestockNotCured">all livestock</option>
                    <option value="showCowNotCured">cow</option>
                    <option value="showPigNotCured">pig</option>
                </select>
                <input type="submit" value="search"/>
            </form>
        </div>

        <table>
            <tr>
                <c:choose>
                        <c:when test="${requestScope.livestockType == 'cow'}">
                        <th>Cow Id</th>
                        </c:when>
                        <c:when test="${requestScope.livestockType == 'pig'}">
                        <th>Pig Id</th>
                        </c:when>
                        <c:otherwise>
                        <th>Livestock Id</th>
                        </c:otherwise>
                    </c:choose>

                <th>Employee_Id</th>
                <th>Age</th>
                <th>Weight</th>
                <th>Gender</th>
            </tr>

            <c:forEach var="livestock" items="${requestScope.livestockList}">
                <tr>
                    <td>${livestock.id}</td>
                    <td>${livestock.employeeId}</td>
                    <td>${livestock.age}</td>
                    <td>${livestock.weight}</td>
                    <td>${livestock.gender}</td>
                </tr>
            </c:forEach>

        </table>

    </body>
</html>
