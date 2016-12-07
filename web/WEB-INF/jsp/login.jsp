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
        <style>

            a{
                text-decoration: none; 
                display: block;
                color:black;
                font-family:Lucida Grande;
                width: 5%;
                padding: 10px 15px;
                border: solid 1px #3c6e09;
                text-align: center;
            }

            #form{
                width: 50%;
                margin: auto;
                padding: 20px 30px;
                border: 2px solid black;
                border-radius: 8px;
                font-size: 15px;
                font-family:Lucida Grande;

            }

            input{
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
            }

            #submit{
                diplay:block;
                width: 80%;
                font-size: 15px;
                font-family:Lucida Grande;
                padding:10px;
                background-color :black;
                color: white;
                border-radius:8px;

            }
        </style>
    </head>
    <body>
        <form action="login.htm?action=login"  method="post" id="form">

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

            <input type="submit" value="login" id="submit"> <br/><br/>

<a href="showAllCow.htm" >Back</a>


        </form>
        

    </body>
</html>
