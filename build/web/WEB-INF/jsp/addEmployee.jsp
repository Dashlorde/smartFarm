<%-- 
    Document   : addEmployee
    Created on : Nov 30, 2016, 11:00:33 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Employee</title>
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
        <form action="addemployee.htm"  method="post" >

            <table>
                <!--<tr>
                    <td>Employee Id:</td>
                    <td><input type="text" name="Id" size="30" /></td>
                    <td><div style="color:red">${error} </div></td>
                </tr>-->



                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" size="30" /></td>
                </tr>

                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="phone" size="30" /></td>
                </tr>

                <tr>
                    <td>Category:</td>
                    <td><select name = "category">
                            <option value="cow">Cow</option>
                            <option value="pig">Pig</option>
                        </select>
                    </td>
                </tr>
                
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" size="30" /></td>
                </tr>

            </table>

            <input type="submit" value="Add Employee" id="submit"> <br/><br/><br/>
            <a href="manageemployee.htm" >Cancel and Back</a><br/>

        </form>
    </body>
</html>