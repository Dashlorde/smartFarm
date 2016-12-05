<%-- 
    Document   : modify
    Created on : 2016-12-2, 13:13:13
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modify Livestock</title>
    </head>
    <body>
        <form action="modifyLivestock.htm?id=${requestScope.id}&type=${requestScope.livestockType}" method="post">
        
            <table>
                <tr>
                    <td>Change Employee Id: </td>
                    <td><input type="text" name="employeeId" size="30" /></td>
                </tr>
                
                <tr>
                    <td>Change Weight:</td>
                    <td><input type="text" name="weight" size="30" /></td>
                </tr>
            </table>
            <input type="submit" value="modify livestock" id="submit"> <br/>
            
        </form>
        <br/><br/>
            <c:choose>
                <c:when test = "${requestScope.livestockType == 'cow'}">
                     <a href="showAllCow.htm" >Back to Main Menu</a><br/>
                </c:when>
                 <c:when test = "${requestScope.livestockType == 'pig'}">
                     <a href="showAllPig.htm" >Back to Main Menu</a><br/>
                </c:when>
            </c:choose>
    </body>
</html>
