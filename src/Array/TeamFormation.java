package Array;

import java.util.*;

public class TeamFormation {

    public static int countTeams(int[] skills, int minPlayers, int minLevel, int maxLevel) {
        // Filter players based on skill levels
        List<Integer> eligiblePlayers = new ArrayList<>();
        for (int skill : skills) {
            if (skill >= minLevel && skill <= maxLevel) {
                eligiblePlayers.add(skill);
            }
        }

        // Count teams
        int count = 0;
        for (int i = minPlayers; i <= eligiblePlayers.size(); i++) {
            count += countCombinations(eligiblePlayers.size(), i);
        }
        return count;
    }

    private static int countCombinations(int n, int k) {
        int result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] skills = {12, 4, 6, 13, 5, 10};
        int minPlayers = 3;
        int minLevel = 4;
        int maxLevel = 10;
        System.out.println("Number of teams: " + countTeams(skills, minPlayers, minLevel, maxLevel));
    }
}

