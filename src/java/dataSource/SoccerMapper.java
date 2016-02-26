/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edipetres
 */


public class SoccerMapper {
    
    public Player getPlayer(int playerid, Connection conn){
        Player p = null;
        String sqlString = "select * from player where Player_id=?";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sqlString);
            stmt.setInt(1, playerid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p = new Player(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println("Error in soccerMapper getPlayer");
            System.out.println("Exception = " + ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Error while trying to close stmt.");
                System.out.println("Exception = " + ex);
            }
        }
        return p;
    }
    
    public boolean updatePlayer(Connection conn, Player player ){
        
        //It should not be possible to change the playerid!
        
        
        String sql = "update player\n" +
        "set Player_name = ?,Player_position=?,Player_number=?,Team_id=?\n" +
        "where Player_id = ?;";
        PreparedStatement updateStatement;
        try {
        updateStatement = conn.prepareStatement(sql);
        updateStatement.setString(1, player.getPlayerName());
        updateStatement.setString(2, player.getPlayerPos());
        updateStatement.setInt(3, player.getPlayerNumber());
        updateStatement.setString(4, player.getTeamid());
        updateStatement.setInt(5, player.getPlayerid());
        return updateStatement.execute();
        } catch (SQLException ex) {
            System.out.println("SQL EX IN Update Player" + ex);
        }
        return false;
    }
    
    public List<Goal> getAllGoals(Connection conn){
        
        String sql = "Select * from goal";
        ArrayList<Goal> allgoals = new ArrayList<>();
        try {
            PreparedStatement getGoals = conn.prepareStatement(sql);
            ResultSet rs = getGoals.executeQuery();
            
            while(rs.next()){
                Goal temp = new Goal(rs.getInt("Goal_id"), rs.getInt("Player_id"), rs.getInt("Match_id"), rs.getString("Goal_type"));
                allgoals.add(temp);
            }
            
            return allgoals;
        } catch (SQLException ex) {
            System.out.println("SQL EX IN GET ALL GOALS "  + ex );
        }
        return null;
    }
    
    public List<Match> getMatches(Connection conn){
        
        String sql = "Select * from match";
        ArrayList<Match> allMatches = new ArrayList<>();
        try {
            PreparedStatement getGoals = conn.prepareStatement(sql);
            ResultSet rs = getGoals.executeQuery();
            
            while(rs.next()){
                Match temp = new Match(rs.getInt("Match_id"), rs.getString("Team1_id"), rs.getString("Team2_id"));
                allMatches.add(temp);
            }
            
            return allMatches;
        } catch (SQLException ex) {
            System.out.println("SQL EX IN GET ALL Matches "  + ex );
        }
        return null;
    }
    
    public List<Team> getTeams(Connection conn){
        
        String sql = "Select * from team";
        ArrayList<Team> allTeams = new ArrayList<>();
        try {
            PreparedStatement getGoals = conn.prepareStatement(sql);
            ResultSet rs = getGoals.executeQuery();
            
            while(rs.next()){
                Team temp = new Team(rs.getString("Team_id"));
                allTeams.add(temp);
            }
            
            return allTeams;
        } catch (SQLException ex) {
            System.out.println("SQL EX IN GET ALL Teams "  + ex );
        }
        return null;
    }
    
     public ArrayList<Player> getAllPlayers(Connection conn) {
        ArrayList<Player> playerList = new ArrayList<>();
        String sqlString = "select * from player";
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlString);
            while (rs.next()) {
                Player p = new Player(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5));
                playerList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Exception = " + ex);
        } finally {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Exception = "+ex);
            }
        }
        return playerList;
    } 
    
    
}
