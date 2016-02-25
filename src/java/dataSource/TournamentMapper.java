/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import domain.Goal;
import domain.Match;
import domain.Player;
import domain.Team;
import domain.TeamAllInfo;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class TournamentMapper {
   
   
    
    public List<TeamAllInfo> getSortedTeamTable( Connection con){
        
        List<Team> teams = getAllteams(con);
        
        //The map should contain matchId as the Integer and the list of goals with that matchId.
        HashMap<Integer,List<Goal>> goals = getAllGoals(con);
        List<Match> matches = getAllMatches(con);
        
        //String is used to Identify the Team fast, and TeamAllInfo stores values
        HashMap<String, TeamAllInfo> mapOfTeamInfo = new HashMap<>();
        
        
        // Create all the teams, without data
        for (Team team : teams) {
           mapOfTeamInfo.put(team.getTeamId(), new TeamAllInfo(team.getTeamId(), 0, 0, 0, 0, 0, 0, 0));
        }
        
       /*
        Calculates all the matches, and assign points and goals for each team.
        */
        for (Match match : matches) {
            String team1Id = match.getTeam1Id();
            String team2Id = match.getTeam2Id();
            
            // This is justed to store infomation back into the hashmap
           TeamAllInfo tempTeamOne = mapOfTeamInfo.get(team1Id);
           TeamAllInfo tempTeamTwo = mapOfTeamInfo.get(team2Id);
                
           List<Goal> listOfGoalsForTheMatch = goals.get(match.getMatchId());
            
                int goalsForTeam1=0;
                int goalsForTeam2=0;
            for (Goal goal : listOfGoalsForTheMatch) {
                int iDofPlayerthatScored = goal.getPlayerId();
                Player playerThatScored = getPlayer(con, iDofPlayerthatScored);
                String teamIdOfPlayerThatScored = playerThatScored.getTeamid();
                
                if(teamIdOfPlayerThatScored.equals(team1Id)){
                    goalsForTeam1++;
                }
                else if(teamIdOfPlayerThatScored.equals(team2Id)){
                    goalsForTeam2++;
                }
                else{
                    System.out.println("Shold not go here");
                }
            }
            
            //Setting games played:
            tempTeamOne.setGamesPlayed(tempTeamOne.getGamesPlayed() +1);
            tempTeamTwo.setGamesPlayed(tempTeamTwo.getGamesPlayed() +1);
            
            // Setting Goals scored
            tempTeamOne.setGoalsFor(tempTeamOne.getGoalsFor() + goalsForTeam1);
            tempTeamTwo.setGoalsFor(tempTeamTwo.getGoalsFor() + goalsForTeam2);
                
                
            //Setting Goals Conceived
            tempTeamOne.setGoalsAgianst(tempTeamOne.getGoalsAgianst() + goalsForTeam2);
            tempTeamTwo.setGoalsAgianst(tempTeamTwo.getGoalsAgianst() + goalsForTeam2);
            
            if(goalsForTeam1 > goalsForTeam2){
                //Team one WON! Setting values:
                
                //setting points
                tempTeamOne.setPoints(tempTeamOne.getPoints() + 3);
                tempTeamTwo.setPoints(tempTeamTwo.getPoints() + 0);
                
               //setting winners and Losers
                tempTeamOne.setGamesWon(tempTeamOne.getGamesWon()+1);
                tempTeamTwo.setGamesLost(tempTeamTwo.getGamesLost()+1);
                
         
            }
            
            else if(goalsForTeam1 < goalsForTeam2){
                // Team two WON!
                
                //setting points
                tempTeamOne.setPoints(tempTeamOne.getPoints() + 0);
                tempTeamTwo.setPoints(tempTeamTwo.getPoints() + 3);
                
               //setting winners and Losers
                tempTeamOne.setGamesWon(tempTeamOne.getGamesLost()+1);
                tempTeamTwo.setGamesLost(tempTeamTwo.getGamesWon()+1);
            }
            
            else if(goalsForTeam1 == goalsForTeam2){
                // DRAW!
                
                 //setting points
                tempTeamOne.setPoints(tempTeamOne.getPoints() + 1);
                tempTeamTwo.setPoints(tempTeamTwo.getPoints() + 1);
                
               //setting winners and Losers
                tempTeamOne.setGamesWon(tempTeamOne.getGamesDraw()+1);
                tempTeamTwo.setGamesLost(tempTeamTwo.getGamesDraw()+1);
            }
 
            else{
                System.out.println("Should not go here");
            }
            
            //Start over agian.
            
        }
        
      // out of the loops!
    //Make the hashmap to a list, and sort it by highest points
        
        
        List<TeamAllInfo> unsortedList = new ArrayList<>();
        Collection<TeamAllInfo> Collection = mapOfTeamInfo.values();
        unsortedList.addAll(Collection);
        
        //Sort using  And Comparator
        return null;
    }

    private List<Team> getAllteams(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private HashMap<Integer, List<Goal>> getAllGoals(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Match> getAllMatches(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Player getPlayer(Connection con, int iDofPlayerthatScored) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
