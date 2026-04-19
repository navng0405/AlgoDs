package DP;

import java.util.*;

public class LongestCommonHistory {
    public static List<String> findLongestCommonHistory(String[] user1, String[] user2) {
        int n = user1.length;
        int m = user2.length;
        int[][] dp = new int[n+1][m+1];

        int maxLength = 0;
        int endIndexUser1 = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (user1[i-1].equals(user2[j-1])) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        endIndexUser1 = i-1;
                    }
                }
            }
        }

        // Reconstruct the longest continuous common history
        List<String> result = new ArrayList<>();
        for (int i = endIndexUser1 - maxLength + 1; i <= endIndexUser1; i++) {
            result.add(user1[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] user1 = {"3234.html", "xys.html", "7hsaa.html"};
        String[] user2 = {"3234.html", "sdhsfjdsh.html", "xys.html", "7hsaa.html"};

        List<String> result = findLongestCommonHistory(user1, user2);
        System.out.println("Longest Continuous Common History: " + result);
    }
}

