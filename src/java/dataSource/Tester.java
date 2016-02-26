/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Player;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author edipetres
 */
public class Tester {
    private static Connection conn;
    private static SoccerMapper sm;
    
    Tester() {
        conn = (Connection) DBConnector.getInstance().getConnection();
        sm = new SoccerMapper();
    }
    
    public static void main(String[] args) {
        Tester t = new Tester();
        ArrayList<Player> playerList = (ArrayList<Player>) sm.getAllPlayers(conn);
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println("Player "+(i+1)+" "+playerList.get(i).getPlayerName());
        }
        
//        Player p = sm.getPlayer(1, conn);
//        System.out.println("Player = " + p.getPlayerName());
    }
}
