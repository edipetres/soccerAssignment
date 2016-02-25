/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import dataSource.*;

/**
 *
 * @author edipetres
 */
public class DomainFacade {
    private Player player;
    private DBFacade dbf;
    
    private DomainFacade() {
        dbf = DBFacade.getInstance();
        player = null;
    }
    
    public static DomainFacade getInstance() {
        return new DomainFacade();
    }
    
    public Player getPlayer(int playerid) {
        return dbf.getPlayer(playerid);
    }
}
