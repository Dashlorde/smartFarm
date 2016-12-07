<%-- 
    Document   : addFeedRecord
    Created on : Dec 4, 2016, 11:50:45 AM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Feed Record</title>
    </head>
    <style>
        #form{
                position: absolute;
                top: 100px;
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
                background-color: black;
                color: white;
                border-radius:8px;

            }
            
            a{
                display: block;
                color:black;
                width: 200px;
                font-family:Lucida Grande;
                padding: 10px 15px;
                text-decoration: none; 
                
            }

    </style>
    <body>
        ${requestScope.type} ID: ${requestScope.id}
        <form action="addfeedrecord.htm"  method="post"id="form" >
            <table>
                <input type = "hidden" name = "id" value = "${requestScope.id}">
                <input type = "hidden" name = "type" value = "${requestScope.type}">

                <tr>
                    <td>Quantity:</td>
                    <td><input type="text" name="quantity" size="30" /></td>
                </tr>

                <tr>
                    <td>Feed Category:</td>
                    <td><input type="text" name="feed" size="30" /></td>
                </tr>

            </table>
            <br/><br/>
            <input type="submit" value="add feedRecord" id="submit"> <br/><br/><br/>

        </form>
        <a href="livestockdetail.htm?type=${requestScope.type}&id=${requestScope.id}">Cancel and Back</a><br/>
    </body>
</html>

