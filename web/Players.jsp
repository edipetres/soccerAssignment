<%-- 
    Document   : Players
    Created on : 25-Feb-2016, 15:09:08
    Author     : edipetres
--%>

<%@page import="java.util.ArrayList"%>
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
            ArrayList<Player> playerList = (ArrayList<Player>) request.getAttribute("playerList");

        %>
        <table>
            <tr>
                <td><b>ID</b></td>
                <td><b>Name</b></td>
                <td><b>Position</b></td>
                <td><b>Number</b></td>
                <td><b>Team id</b></td>
            </tr>
            <%
            if (p != null) {
                    out.println("<tr><td> "+p.getPlayerid()+"</td><td> "+p.getPlayerName()+"</td><td> "+p.getPlayerPos()+"</td> <td> "+p.getPlayerNumber()+"</td><td>"+ p.getTeamid()+"</td></tr>");
                }
            %>
            <tr><td><h3>All players:</h3></td></tr>
            <%
                
                if (playerList != null) {
                    
                    for (int i = 0; i < playerList.size(); i++) {
                        Player pl = (Player) playerList.get(i);
                        out.println("<tr>"
                                + "<td>" + pl.getPlayerid() + "</td>"
                                + "<td>" + pl.getPlayerName() + "</td>"
                                + "<td>" + pl.getPlayerPos() + "</td>"
                                + "<td>" + pl.getPlayerNumber() + "</td>"
                                + "<td>" + pl.getTeamid() + "</td>"
                                + "</tr>");
                    }
                }
                else {
                    
                }
            %>
        </table>
        <form action="UIServlet">
            <input type="text" name="playerid" value="" size="4" />
            <input type="hidden" name="whereTo" value="getplayerwithid">
            <input type="submit" value="Get player">
        </form>
        <form action="UIServlet"> 
            <input type="hidden" name="whereTo" value="getallplayers">
            <input type="submit" value="Show All Players">
        </form>
    </body>
</html>
