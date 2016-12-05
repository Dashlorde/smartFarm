<%-- 
    Document   : addPigController
    Created on : 2016-11-29, 16:56:24
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add pig</title>
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
        <form action="addPig.htm"  method="post" >

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
                    <td>Weight:</td>
                    <td><input type="text" name="weight" size="30" /></td>
                </tr>

                <tr>
                    <td>Gender:</td>
                    <td><select name="gender">
                            <option value="F">Female</option>
                            <option value="M">Male</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Estrous Detection:</td>
                    <td><select name="estrous_detection">
                            <option value="Y">Yes</option>
                            <option value="N">No</option>
                        </select>
                    </td>
                </tr>




            </table>

            <input type="submit" value="add Pig" id="submit"> <br/><br/><br/>


            <a href="showAllPig.htm" >Cancel and Back</a><br/>



        </form>
    </body>
</html>
