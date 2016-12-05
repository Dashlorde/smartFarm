<%-- 
    Document   : addQuarantine
    Created on : Dec 4, 2016, 3:22:34 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Feed Record</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker(
                        {changeMonth: true,
                            changeYear: true, dateFormat: 'yy-mm-dd'});
            });
        </script>
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

    </style>
    <body>
        ${requestScope.type} ID: ${requestScope.id}
        <form action="addquarantine.htm"  method="post" >
            <table>
                <input type = "hidden" name = "id" value = "${requestScope.id}">
                <input type = "hidden" name = "type" value = "${requestScope.type}">

                <tr>
                    <td>Date:</td>
                    <td><input type="text" name="date" id="datepicker" size="30" /></td>
                </tr>

                <tr>
                    <td>Epidemic:</td>
                    <td><input type="text" name="epidemic" size="30" /></td>
                </tr>

                <tr>
                    <td>Location:</td>
                    <td><input type="text" name="location" size="30" /></td>
                </tr>

                <tr>
                    <td>Status:</td>
                    <td>
                        <select name="status">
                            <option value="valid">valid</option>
                            <option value="invalide">invalid</option>
                        </select>  
                    </td>
                </tr>

            </table>
            <br/><br/>
            <input type="submit" value="add quarantine" id="submit"> <br/><br/><br/>

        </form>
        <a href="livestockdetail.htm?type=${requestScope.type}&id=${requestScope.id}">Cancel and Back</a><br/>
    </body>
</html>
