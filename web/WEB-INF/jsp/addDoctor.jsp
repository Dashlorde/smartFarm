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
        <form action="adddoctor.htm"  method="post" id="form">

            <table>
               

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

            <input type="submit" value="Add Doctor" id="submit"> <br/><br/><br/>
             <a href="managedoctor.htm" >Cancel and Back</a><br/>

        </form>
    </body>
</html>
