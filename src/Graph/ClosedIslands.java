package Graph;

public class ClosedIslands {



    public static void main(String[] args) {
        int[][] grid =
                {{0, 0, 0, 0, 0, 0, 0, 1},
                 {0, 1, 1, 1, 1, 0, 0, 1},
                 {0, 1, 0, 1, 0, 0, 0, 1},
                 {0, 1, 1, 1, 1, 0, 1, 0},
                 {1, 0, 0, 0, 0, 1, 0, 1}};
        System.out.println("Number of closed islands: " + numClosedIslands(grid));
    }

    private static int numClosedIslands(int[][] grid) {
        int numberOFCloseIsland = 0;
        if(grid == null || grid.length == 0){
            return numberOFCloseIsland;
        }
        //Initialize variables
        int rowLen = grid.length-1;
        int colLen = grid[0].length-1;

        //Eliminate edge lands
        for(int i=0;i<=rowLen;i++){
            dfs(grid,i,0);
            dfs(grid,i,colLen);
        }

        for(int j=0;j<=colLen;j++){
            dfs(grid,0,j);
            dfs(grid,rowLen,j);
        }

        for(int row = 1;row<=rowLen;row++){
            for(int col=1;col<=colLen;col++){
                if(grid[row][col] == 1){
                    dfs(grid,row,col);
                    numberOFCloseIsland++;
                }
            }
        }

        return numberOFCloseIsland;
    }

    private static void dfs(int[][] grid, int row, int col){
        //Avoid boundaries
        if(row <0 || row>= grid.length || col<0 || col>=grid[0].length || grid[row][col] == 0){
            return;
        }
        grid[row][col] = 0;
        dfs(grid, row-1,col);
        dfs(grid,row+1,col);
        dfs(grid,row,col-1);
        dfs(grid,row,col+1);

    }
}

