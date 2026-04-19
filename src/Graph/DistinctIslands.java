package Graph;

import java.util.HashSet;
import java.util.Set;

public class DistinctIslands {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1},
                {1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Number of distinct islands: " + numDistinctIslands(grid));
    }

    private static int numDistinctIslands(int[][] grid) {
        int rowBegin =0,rowEnd = grid.length-1;
        int colBegin =0,colEnd = grid[0].length-1;
        int countOfIsland = 0;
        Set<String> uniqueIsland = new HashSet<>();
        for(int row = rowBegin;row<=rowEnd;row++){
            for(int col = colBegin;col<=colEnd;col++){
                if(grid[row][col] == 1){
                    StringBuilder shape = new StringBuilder();
                    dfsUtil(grid,row,col,shape,"O");
                    uniqueIsland.add(shape.toString());
                }

            }
        }
        return uniqueIsland.size();

    }

    private static void dfsUtil(int[][] grid, int row, int col, StringBuilder shape, String dir) {
        //Check boundary
        if(row<0 || row >= grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }

        grid[row][col] = 0;
        shape.append(dir);
        dfsUtil(grid,row-1,col,shape,"U");
        dfsUtil(grid,row+1,col,shape,"D");
        dfsUtil(grid,row,col-1,shape,"L");
        dfsUtil(grid,row,col+1,shape,"R");
        shape.append("B");

    }
}
