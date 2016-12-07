<%-- 
    Document   : addCowController
    Created on : 2016-11-29, 16:56:07
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add cow</title>
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
    <body>
        <form action="addCow.htm"  method="post" id="form">

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


            </table>

            <input type="submit" value="add Cow" id="submit"> <br/><br/><br/>
            <a href="showAllCow.htm" >Cancel and Back</a><br/>




        </form>
    </body>
</html>
