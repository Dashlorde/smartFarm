<%-- 
    Document   : addSensorJsp
    Created on : 2016-12-5, 1:59:39
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Sensor Page</title>
    </head>
    <body>
        
        <form action="addSensor.htm"  method="post" >

            <table>


                <tr>
                    <td>Livestock_Id</td>
                    <td><input type="text" name="livestockId" size="30" /></td>
                </tr>

                
                <tr>
                    <td>type:</td>
                    <td><select name="sensorType">
                            <option value="TEMP">temperature</option>
                            <option value="ACCELERATOR">accelerator</option>
                            <option value="WEIGHT">weight</option>
                            <option value="MILK">milk</option>
                        </select>
                    </td>
                </tr>
                

            </table>

            <input type="submit" value="add Sensor" id="submit"> <br/><br/><br/>
 
        </form>
    </body>
</html>
