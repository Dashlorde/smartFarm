<%-- 
    Document   : addSensor
    Created on : 2016-12-4, 23:18:34
    Author     : jingli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Sensor</title>
    </head>
    <body>
        <form action="addsensor.htm"  method="post" >

            <table>
                <!--<tr>
                    <td>Employee Id:</td>
                    <td><input type="text" name="Id" size="30" /></td>
                    <td><div style="color:red">${error} </div></td>
                </tr>-->



                <tr>
                    <td>Animal Id:</td>
                    <td><input type="text" name="name" size="30" /></td>
                </tr>

                <tr>
                    <td>Sensor Id:</td>
                    <td><input type="text" name="phone" size="30" /></td>
                </tr>

                <tr>
                    <td>SensorType:</td>
                    <td><input type="text" name="phone" size="30" /></td>
                </tr>
                
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" size="30" /></td>
                </tr>

            </table>

            <input type="submit" value="Add Employee" id="submit"> <br/>

        </form>
    </body>
</html>
