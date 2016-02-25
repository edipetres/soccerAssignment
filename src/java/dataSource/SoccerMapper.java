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
}
