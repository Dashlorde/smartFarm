<%-- 
    Document   : addSensorJsp
    Created on : 2016-12-5, 1:59:39
    Author     : zhouyunlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Sensor Page</title>
        <style>
             ul.menu{
                background-color: #f1f1f1;
                list-style-type:none;
                margin:0;
                padding:0;
                width:100%;
                opacity: 0.8;

            }

            .menu li {
                float: left;
            }

           .menu a{
                display: block;
                color:black;
                text-align:center;
                font-family:Lucida Grande;
                padding: 10px 15px;
                text-decoration: none; 
            }

            .menu a:hover{
                background-color: black;
                color:white;
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
    </head>
    <body>
        <div><jsp:include page="menu3.jsp"/></div>
        
        <form action="addSensor.htm"  method="post" id="form">

            <table>


                <tr>
                    <td>Livestock_Id</td>
                    <td><input type="text" name="livestockId" size="30" /></td>
                </tr>

                
                <tr>
                    <td>type:</td>
                    <td><select name="sensorType">
                            <option value="TEMP">temperature</option>
                            <option value="ACCELERATOR">accelerator</option>
                            <option value="WEIGHT">weight</option>
                            <option value="MILK">milk</option>
                        </select>
                    </td>
                </tr>
                

            </table>

            <input type="submit" value="add Sensor" id="submit"> <br/><br/><br/>
 
        </form>
        
    </body>
</html>
