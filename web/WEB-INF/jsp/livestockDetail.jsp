<%-- 
    Document   : livestockDetial
    Created on : Dec 3, 2016, 10:05:26 AM
    Author     : he.fa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livestock Information</title>
    </head>
    <style>
        table, th, td{
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;

        }

        th,td{
            padding: 10px 15px;
        }

        table{
            width: 100%
        }
        a{
            text-decoration: none; 
            display: block;
            color:black;
            text-align: right;
        }
        a.sensor{
            text-decoration: none; 
            display: block;
            color:red;
            text-align: left;
        }
    </style>
    <body>
        <h2>Livestock Detail</h2>
        <c:choose>
            <c:when test = "${requestScope.type == 'cow'}">
                <a href="showAllCow.htm" >Back</a><br/>
            </c:when>
            <c:when test = "${requestScope.type == 'pig'}">
                <a href="showAllPig.htm" >Back</a><br/>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test = "${requestScope.type == 'cow'}">
                Cow ID: ${requestScope.id}
            </c:when>
            <c:when test = "${requestScope.type == 'pig'}">
                Pig ID: ${requestScope.id}
            </c:when>
        </c:choose>
                
        <a href = "livestockallsenserdetail.htm?livestock_id=${requestScope.id}&source=livestockdetail&type=${requestScope.type}" class = "sensor">Sensor Monitor</a>

        <div>
            <h3>Feed Record</h3>
            <a href="addfeedrecord.htm?type=${requestScope.type}&id=${requestScope.id}">Add New Feed Record</a>

            <table>
                <tr>
                    <th>Feed Time</th>
                    <th>Feed Quantity</th>
                    <th>Feed Category</th>
                </tr>
                <c:forEach var = "feedRecord" items = "${requestScope.feedRecordList}">
                    <tr>
                        <td>${feedRecord.time}</td>
                        <td>${feedRecord.quantity}</td>
                        <td>${feedRecord.feed}</td>
                    </tr>
                </c:forEach>    
            </table>
        </div>


        <div>
            <h3>Quarantine Detail</h3>

            <a href="addquarantine.htm?type=${requestScope.type}&id=${requestScope.id}">Add New Quarantine Record</a>

            <table>
                <tr>
                    <th>Receive Quarantine Time</th>
                    <th>Epidemic</th>
                    <th>Location</th>
                    <th>Status</th>

                </tr>
                <c:forEach var = "quarantine" items = "${requestScope.quarantineList}">
                    <tr>
                        <td>${quarantine.time}</td>
                        <td>${quarantine.epidemic}</td>
                        <td>${quarantine.location}</td>
                        <td>${quarantine.status}</td>
                    </tr>
                </c:forEach>    
            </table>
        </div>



        <div>
            <h3>Vaccine Detail</h3>

            <a href="addvaccinerecord.htm?type=${requestScope.type}&id=${requestScope.id}">Add New Vaccine Record</a>

            <table>
                <tr>
                    <th>Vaccine Id</th>
                    <th>Last Vaccine Date</th>
                    <th>Next Vaccine Date</th>

                </tr>
                <c:forEach var = "vaccinerecord" items = "${requestScope.vaccineRecordList}">
                    <tr>
                        <td>${vaccinerecord.vaccineId}</td>
                        <td>${vaccinerecord.lastVaccineDate}</td>
                        <td>${vaccinerecord.nextVaccineDate}</td>
                    </tr>
                </c:forEach>    
            </table>
        </div>


        <div>
            <h3>Disease Record</h3>

            <table>
                <tr>
                    <th>Diagnosis Date</th>
                    <th>Disease ID</th>
                    <th>Doctor ID</th>
                    <th>Cured or Not</th>

                </tr>
                <c:forEach var = "diseasehistory" items = "${requestScope.diseaseHistoryList}">
                    <tr>
                        <td>${diseasehistory.diagnosisDate}</td>
                        <td>${diseasehistory.diseaseId}</td>
                        <td>${diseasehistory.doctorId}</td>
                        <td>${diseasehistory.curedOrNot}</td>
                    </tr>
                </c:forEach>    
            </table>
        </div>
        <br/><br/>
        <a href="livestockdetail.htm?type=${requestScope.type}&id=${requestScope.id}">Refresh</a><br/>
               <!-- <h1>${requestScope.test}</h1>-->

    </body>
</html>
