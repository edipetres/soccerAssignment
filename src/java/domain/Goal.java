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
public class Goal {
    
    private int goalId;
    private int playerId;
    private int matchId;
    private String goaltype;

    public Goal(int goalId, int playerId, int matchId, String goaltype) {
        this.goalId = goalId;
        this.playerId = playerId;
        this.matchId = matchId;
        this.goaltype = goaltype;
    }

    public int getGoalId() {
        return goalId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public String getGoaltype() {
        return goaltype;
    }
    
    
    
}
