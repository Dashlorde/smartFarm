<%-- 
    Document   : addCowController
    Created on : 2016-11-29, 16:56:07
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add cow</title>
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
        <form action="addCow.htm"  method="post" >

            <table>



                <tr>
                    <td>Employee Id:</td>
                    <td><input type="text" name="employeeId" size="30" /></td>
                    <td><div style="color:red">${error} </div></td>
                </tr>



                <tr>
                    <td>Age:</td>
                    <td><input type="text" name="age" size="30" /></td>
                </tr>

                <tr>
                    <td>Milk Production:</td>
                    <td><input type="text" name="milk_production" size="30" /></td>
                </tr>
                <tr>
                    <td>Estrous Detection:</td>
                    <td><select name="estrous_detection">
                            <option value="Y">Yes</option>
                            <option value="N">No</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Weight:</td>
                    <td><input type="text" name="weight" size="30" /></td>
                </tr>





            </table>

            <input type="submit" value="add Cow" id="submit"> <br/><br/><br/>
            <a href="showAllCow.htm" >Cancel and Back</a><br/>




        </form>
    </body>
</html>
