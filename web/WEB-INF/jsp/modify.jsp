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
        <style>
            
            
            #form{
                position: absolute;
                top: 100px;
                width: 50%;
                margin: auto;
                padding: 20px 30px;
                border: 2px solid black;
                border-radius: 8px;
                font-size: 15px;
                font-family:Lucida Grande;

            }

            input{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
            }

            #submit{
                diplay:block;
                width: 80%;
                font-size: 15px;
                font-family:Lucida Grande;
                padding:10px;
                background-color: black;
                color: white;
                border-radius:8px;

            }
            
            a{
                display: block;
                color:black;
                width: 200px;
                font-family:Lucida Grande;
                padding: 10px 15px;
                text-decoration: none; 
                
            }
        
        
        </style>
    </head>
    <body>
        <form action="modifyLivestock.htm?id=${requestScope.id}&type=${requestScope.livestockType}" method="post" id="form">
        
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
                     <br/><br/>
    </body>
</html>
