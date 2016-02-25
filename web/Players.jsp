<%-- 
    Document   : Players
    Created on : 25-Feb-2016, 15:09:08
    Author     : edipetres
--%>

<%@page import="domain.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Players</title>
    </head>
    <body>
        <h1>Here is your player</h1>
        <% 
        Player p = (Player) request.getAttribute("player");
        %>
        <table>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Position</td>
                <td>Number</td>
                <td>Team id</td>
            </tr>
            <tr>
                <td><%= p.getPlayerid()%></td>
                <td><%= p.getPlayerName()%></td>
                <td><%= p.getPlayerPos()%></td>
                <td><%= p.getPlayerNumber()%></td>
                <td><%= p.getTeamid()%></td>
            </tr>
        </table>
            <form action="UIServlet">
                <input type="text" name="playerid" value="" size="4" />
                <input type="hidden" name="whereTo" value="getplayerwithid">
                <input type="submit" value="Get player">
            </form>
    </body>
</html>
