/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edipetres
 */
public class DBFacade {
    private SoccerMapper sm;
    private Connection conn;
    
    private static DBFacade instance;
    
    private DBFacade() {
        sm = new SoccerMapper();
        conn = DBConnector.getInstance().getConnection();
    }
    
    public static DBFacade getInstance() {
        if (instance == null) {
            instance = new DBFacade();
        }
        return instance;
    }
    
    public Player getPlayer(int playerid) {
        return sm.getPlayer(playerid,conn);
    }
    
    public ArrayList<Player> getAllPlayers() {
        return sm.getAllPlayers(conn);
    }
}
