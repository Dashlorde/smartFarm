<%-- 
    Document   : addDoctor
    Created on : Dec 2, 2016, 3:12:41 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Doctor</title>
    </head>
    <body>
        <form action="adddoctor.htm"  method="post" >

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
                    <td>Specialty:</td>
                    <td><input type="text" name="speciaty" size="30" /></td>
                </tr>
                
                 <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" size="30" /></td>
                </tr>

            </table>

            <input type="submit" value="Add Doctor" id="submit"> <br/>

        </form>
    </body>
</html>
