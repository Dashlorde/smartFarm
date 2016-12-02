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
    <body>
        <form action="addPig.htm"  method="post" >

<table>
    
<tr>
	<td>Pig Id:</td>
	<td><input type="text" name="id" size="30" /></td>
	
</tr>

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
	<td><input type="text" name="gender" size="30" /></td>
</tr>





</table>

<input type="submit" value="add Pig" id="submit"> <br/>

 


</form>
    </body>
</html>
