<%-- 
    Document   : adminLogin
    Created on : Nov 29, 2016, 8:36:50 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Login Page</title>
         <style>
             h1 {
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
        <h1>Welcome to Login our System!</h1>
        <form action="j_security_check" method="post" id="form">
            <table>
                <tr><td>User name: </td><td><input type="text" name="j_username"></td>
                <tr><td>Password: </td><td><input type="password" name="j_password"></td>
                <tr><th><input type="submit" value="Log In" id="submit">
            </table>
        </form>
    </body>
</html>

