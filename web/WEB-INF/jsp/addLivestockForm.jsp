<%-- 
    Document   : addLivestockForm
    Created on : 2016-11-29, 19:01:19
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Livestock</title>
    </head>
    <body>
        <form action="addLivestock.htm"  method="post" >

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
	<td><input type="text" name="gender" size="30" /></td>
</tr>

<tr>
    <td>Type</td>
    <td>
        <select name="type">
            <option value="cow">cow</option>
            <option value="pig">pig</option>
       </select>
    </td>
</tr>



</table>

<input type="submit" value="add livestock" id="submit"> <br/>

 


</form>
    </body>
</html>
