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

        <input type="submit" onclick="breakout()" value="Log out">


    </body>
</html>
