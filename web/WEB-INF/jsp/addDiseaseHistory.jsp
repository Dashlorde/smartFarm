<%-- 
    Document   : addDiseaseHistory
    Created on : Dec 4, 2016, 8:49:57 PM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Add Disease Record</title>
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
        <form action="adddiseasehistory.htm"  method="post" >

            <table>
                
                <input type="hidden" name="doctor_id" value="${sessionScope.Id}"/>

                <tr>
                    <td>Livestock ID:</td>
                    <td><input type="text" name="livestock_id" size="30" /></td>
                </tr>

                <tr>
                    <td>Diagnosis_Date:</td>
                    <td><input type="text" name="date" id="datepicker" size="30" /></td>
                </tr>

                <tr>
                    <td>Disease ID:</td>
                    <td><input type="text" name="disase_id" size="30" /></td>
                </tr>

                <tr>
                    <td>Cured_or_Not:</td>
                    <td><select name="cure_or_not">
                            <option value="cure">Cure</option>
                            <option value="not">Not</option>
                        </select>
                    </td>
                </tr>

            </table>

            <input type="submit" value="Add Disease" id="submit"> <br/><br/><br/>

        </form>
        <a href="managediseasehistory.htm" >Cancel and Back</a><br/>
    </body>
</html>
