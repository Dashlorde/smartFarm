<%-- 
    Document   : login
    Created on : 2016-11-28, 2:57:39
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="login.htm?action=login"  method="post" >

<table>
<tr>
	<td>User Name:</td>
	<td><input type="text" name="username" size="30" /></td>
	<td><div style="color:red">${error} </div></td>
</tr>

<tr>
	<td>Password:</td>
	<td><input type="password" name="password" size="30" /></td>
</tr>

    <tr>
	<td>character:</td>
            <td>
                    <select name="character">
                            <option value="doctor">doctor</option>
                            <option value="employee">employee</option>
                    </select>
            </td>
    </tr>



</table>

<input type="submit" value="login" id="submit"> <br/>

 


</form>

    </body>
</html>
