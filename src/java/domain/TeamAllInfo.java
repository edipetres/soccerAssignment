/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Daniel
 */
public class TeamAllInfo {
    
    
    private String teamId;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesDraw;
    private int gamesLost;
    private int goalsFor;
    private int goalsAgianst;
    private int points;

    public TeamAllInfo(String teamId, int gamesPlayed, int gamesWon, int gamesDraw, int gamesLost, int goalsFor, int goalsAgianst, int points) {
        this.teamId = teamId;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesDraw = gamesDraw;
        this.gamesLost = gamesLost;
        this.goalsFor = goalsFor;
        this.goalsAgianst = goalsAgianst;
        this.points = points;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesDraw() {
        return gamesDraw;
    }

    public void setGamesDraw(int gamesDraw) {
        this.gamesDraw = gamesDraw;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgianst() {
        return goalsAgianst;
    }

    public void setGoalsAgianst(int goalsAgianst) {
        this.goalsAgianst = goalsAgianst;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    
    
}
