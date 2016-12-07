<%-- 
    Document   : addVaccine
    Created on : Dec 3, 2016, 10:56:17 AM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Vaccine</title>
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
                position: absolute;
                top: 60px;
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
        <form action="addvaccine.htm"  method="post" id="form" >

            <table>

                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" size="30" /></td>
                </tr>

                <tr>
                    <td>Prevented Disease:</td>
                    <td><input type="text" name="prevent_disease" size="30" /></td>
                </tr>

                <tr>
                    <td>Group:</td>
                   <td><input type="text" name="group" size="30" /></td>
                </tr>
                
                 <tr>
                    <td>Vaccine Age:</td>
                    <td><input type="text" name="vaccine_age" size="30" /></td>
                </tr>
                
                <tr>
                    <td>Immune Period:</td>
                    <td><input type="text" name="immune_period" size="30" /></td>
                </tr>

            </table>

            <input type="submit" value="Add Vaccine" id="submit"> <br/><br/><br/>
            <a href="managevaccine.htm" >Cancel and Back</a><br/>
        </form>
    </body>
</html>
