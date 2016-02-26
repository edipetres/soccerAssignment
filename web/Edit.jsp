<%-- 
    Document   : Edit
    Created on : 25-Feb-2016, 11:40:15
    Author     : Daniel
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit stats</title>
    </head>
    <body>
        <h1>Hello From Edit Stats</h1>
        
        <br>
        
        <h2> Choose a player to edit</h2>
        
        <form name="EditForm" action="UIServlet">
            
            Player:
            
            <select name="PlayerDropDown">
                <c:forEach items = "${requestScope.Players}" var = "Player">
                    <option value="${Player.playerid}">${Player.teamid} - ${Player.playerName}  </option>
                </c:forEach>
            </select>
            
            <input type="hidden" name="whereTo" value="updatePlayer" />
            <input type="submit" value="Choose Player" name="Submit" />
        </form>
        
        
        <form name="back" action="UIServlet">
            
            <input type="hidden" name="whereTo" value="back" />
            <input type="submit" value="Back" name="submit" />
        </form>
        
        
        <br>
        <br>
        
        Add New Player
        <form name="AddNewPlayer" action="UIServlet">
           Player Name <input type="text" name="PlayerName" value="" /> <br>
           Player Position <select name="PlayerPosition">
               <option>GK</option>
               <option>DEF</option>
               <option>MF</option>
               <option>ATT</option>
           </select> <br>
           PlayerNumber <select name="PlayerNumber">
               <option>1</option>
               <option>2</option>
               <option>3</option>
               <option>4</option>
               <option>5</option>
               <option>6</option>
               <option>7</option>
               <option>8</option>
               <option>9</option>
               <option>10</option>
               <option>11</option>
               <option>12</option>
               <option>13</option>
               <option>14</option>
               <option>15</option>
               <option>16</option>
               <option>17</option>
               <option>18</option>
               <option>19</option>
               <option>20</option>
               <option>21</option>
               <option>22</option>
               <option>23</option>
               <option>24</option>
               <option>25</option>
               <option>26</option>
               <option>27</option>
               <option>28</option>
               <option>29</option>
               <option>30</option>
           </select>
          Team:
          <select name="Team">
              <option>Aab</option>
              <option>AGF</option>
              <option>Brøndby</option>
              <option>Esbjerg fB</option>
              <option>FC København</option>
              <option>FC Midtjylland</option>
              <option>FC Nordsjælland</option>
              <option>Hobro IK</option>
              <option>OB</option>
              <option>Randers FC</option>
              <option>Sønderjyske</option>
              <option>Viborg</option>
          </select>
            
          <input type="hidden" name="whereTo" value="CreatePlayer" />
          <input type="submit" value="Create Player" name="CreatePlayerSubmit" />
          
          
        </form>
        
        
    </body>
</html>
