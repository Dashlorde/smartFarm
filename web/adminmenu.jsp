<%-- 
    Document   : adminmenu
    Created on : Nov 29, 2016, 10:08:03 PM
    Author     : he.fa
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Menu</title>
        <style>
            a{
            display: block;
            color:black;
            text-align:left;
            font-family:Lucida Grande;
            padding: 10px 15px;
            text-decoration: none; 
        }
        
        a:hover{
            color:white;
            background-color: black;
        }
        
        body{
            background-color: #f1f1f1;
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
    <script>
        function breakout() {
            if (window.top !== window.self) {
                window.top.location = "showAllCow.htm";
            }
        }
    </script>
    <body>
        <a href="manageemployee.htm" target="contents">Manage Employee</a><br/><br/>
        <a href="managedoctor.htm" target="contents">Manage Doctor</a><br/><br/>
        <a href="managelivestock.htm" target="contents">Manage Livestock</a><br/><br/>
        <a href="showOverview.htm" target="contents">Overwiew</a><br/><br/>

        <input type="submit" onclick="breakout()" value="Log out" id="submit">


    </body>
</html>
