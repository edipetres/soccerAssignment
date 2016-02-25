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
public class Match {
    
    private int matchId;
    private String team1Id;
    private String team2Id;

    public Match(int matchId, String team1Id, String team2Id) {
        this.matchId = matchId;
        this.team1Id = team1Id;
        this.team2Id = team2Id;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getTeam1Id() {
        return team1Id;
    }

    public String getTeam2Id() {
        return team2Id;
    }
    
    
    
}
