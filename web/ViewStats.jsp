<%-- 
    Document   : ViewStats
    Created on : 25-Feb-2016, 11:30:49
    Author     : Daniel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Stats Site</title>
    </head>
    <body>
        <h1>Hello From the View Stats</h1>
        
        <form name="back" action="UIServlet">
            
            <table border="1" id="Players">
                <thead>
                    <tr>
                        <th>PlayerID</th>
                        <th>Player_Name</th>
                        <th>Player_Position</th>
                        <th>Player_number</th>
                        <th>Team_id</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.Player}" var = "Player">
                    <tr>
                        <td>${Player.playerid}</td>
                        <td>${Player.playerName}</td>
                        <td>${Player.playerPos}</td>
                        <td>${Player.playerNumber}</td>
                        <td>${Player.teamid}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            
            
            
            
            
            
            
            <input type="hidden" name="whereTo" value="back" />
            <input type="submit" value="Back" name="submit" />
        </form>
        
        
    </body>
</html>
