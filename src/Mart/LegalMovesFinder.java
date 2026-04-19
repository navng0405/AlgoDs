package Mart;

import java.util.ArrayList;
import java.util.List;

public class LegalMovesFinder {

    public static List<int[]> findLegalMoves(int[][] grid, int i, int j) {
        List<int[]> legalMoves = new ArrayList<>();
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Directions: up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            // Check if the new position is within the grid bounds and the value is 0
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] == 0) {
                legalMoves.add(new int[]{newRow, newCol});
            }
        }

        return legalMoves;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 0, 1},
                {1, 0, 1, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 1, 1, 1}
        };

        int i = 0; // Row index of the current position
        int j = 1; // Column index of the current position

        List<int[]> legalMoves = findLegalMoves(grid, i, j);
        System.out.println("Legal moves from (" + i + ", " + j + "):");
        for (int[] move : legalMoves) {
            System.out.println("(" + move[0] + ", " + move[1] + ")");
        }
    }
}

