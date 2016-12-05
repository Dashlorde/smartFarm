<%-- 
    Document   : addFeedRecord
    Created on : Dec 4, 2016, 11:50:45 AM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Feed Record</title>
    </head>
    <style>
        a{
            display: block;
            color:black;
            text-align:left;
            font-family:Lucida Grande;
            padding: 10px 15px;
            text-decoration: none; 
        }

    </style>
    <body>
        ${requestScope.type} ID: ${requestScope.id}
        <form action="addfeedrecord.htm"  method="post" >
            <table>
                <input type = "hidden" name = "id" value = "${requestScope.id}">
                <input type = "hidden" name = "type" value = "${requestScope.type}">

                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" name="quantity" size="30" /></td>
                </tr>

                <tr>
                    <td>Feed Category:</td>
                    <td><input type="text" name="feed" size="30" /></td>
                </tr>

            </table>
            <br/><br/>
            <input type="submit" value="add feedRecord" id="submit"> <br/><br/><br/>

        </form>
        <a href="livestockdetail.htm?type=${requestScope.type}&id=${requestScope.id}">Cancel and Back</a><br/>
    </body>
</html>

