package Mart;

import java.util.*;

public class TeamFormation {
    public static void main(String[] args) {
        int[] skills = {4, 12,6,5,13,10};
        int minPlayers = 3;
        int minLevel = 4;
        int maxLevel = 10;
        System.out.println("Number of teams: " + countTeams(skills, minPlayers, minLevel, maxLevel));
        System.out.println("List of teams: " + listTeams(skills, minPlayers, minLevel, maxLevel));
    }

    private static List<List<Integer>> listTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
        List<Integer> eligiblePlayers = new ArrayList<>();
        for(int i:skills){
            if(i >= minLevel && i<=maxLevel){
                eligiblePlayers.add(i);
            }
        }
        List<List<Integer>> teams = new ArrayList<>();
        for(int i = minPlayers;i<=eligiblePlayers.size();i++){
            List<Integer> currentTeam = new ArrayList<>();
            combine(eligiblePlayers,teams,new ArrayList<>(),i,0);
        }
        return teams;
    }

    private static void combine( List<Integer> eligiblePlayers, List<List<Integer>> teams, List<Integer> currentTeam, int minTeamSize, int start) {
        if( currentTeam.size() == minTeamSize){
            teams.add(new ArrayList<>(currentTeam));
            return;
        }

        for(int i=start;i<eligiblePlayers.size();i++){
            currentTeam.add(eligiblePlayers.get(i));
            combine(eligiblePlayers,teams,currentTeam,minTeamSize,i+1);
            currentTeam.remove(currentTeam.size()-1);
        }
    }

    private static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
        int count = 0;
        List<Integer> eligiblePlayers = new ArrayList<>();
        for(int i : skills){
            if(i>=minLevel && i<=maxLevel){
                eligiblePlayers.add(i);
            }
        }

        //CountCombination formula = C(n,k) = n!/k!(n-k)!
        for(int i=minPlayers;i<=eligiblePlayers.size();i++){
            count += getCombinationCount(eligiblePlayers.size(),i);
        }
        return count;
    }

    private static int getCombinationCount(int size, int k) {
        int result = 1;
        for(int i=0;i<k;i++){
            result = result*(size-i);
            result = result/(i+1);
        }
        return result;
    }


}
