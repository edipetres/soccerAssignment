/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author edipetres
 */
public class Player {
    
    private int playerid;
    private String playerName;
    private String playerPos;
    private int playerNumber;
    private String teamid;

    public Player(int playerid, String playerName, String playerPos, int playerNumber, String teamid) {
        this.playerid = playerid;
        this.playerName = playerName;
        this.playerPos = playerPos;
        this.playerNumber = playerNumber;
        this.teamid = teamid;
    }

    public int getPlayerid() {
        return playerid;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerPos() {
        return playerPos;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getTeamid() {
        return teamid;
    }
    
}
