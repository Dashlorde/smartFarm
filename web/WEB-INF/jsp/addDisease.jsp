<%-- 
    Document   : addDisease
    Created on : Dec 4, 2016, 8:36:27 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Disease</title>
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
        <form action="adddisease.htm"  method="post" >

            <table>

                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" size="30" /></td>
                </tr>

                <tr>
                    <td>Description:</td>
                    <td><input type="text" name="description" size="30" /></td>
                </tr>

                <tr>
                    <td>Cure:</td>
                    <td><input type="text" name="cure" size="30" /></td>
                </tr>

                <tr>
                    <td>Region:</td>
                    <td><input type="text" name="region" size="30" /></td>
                </tr>

            </table>

            <input type="submit" value="Add Disease" id="submit"> <br/><br/><br/>

        </form>
        <a href="managedisease.htm" >Cancel and Back</a><br/>
    </body>
</html>