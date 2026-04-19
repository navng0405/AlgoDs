package Matrices;

/**
 * Initialize direction array = > right,down,left,up -> {{0,1},{1,0},{0,-1,-1,0}}
 * initialize memo[][] as same size as given matrix
 * Iterate each cell
 * call dfs method to get longestpath for each cell and faid which has the longest path
 *
 */
public class LongestIncreasingPath {
    public static void main(String[] args) {
        int[][] giveMatrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(findPath(giveMatrix));
    }
    private static int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}}; // Right, Down, Left, Up

    private static int findPath(int[][] giveMAtrix){
        int rowLength = giveMAtrix.length;
        int colLength = giveMAtrix[0].length;
        int longestPath =0 ;
        int[][] memo = new int[rowLength][colLength];
        for(int row=0;row<rowLength;row++){
            for(int col=0;col<colLength;col++){
                longestPath = Math.max(dfsPathFinding(giveMAtrix,row,col,memo),longestPath);
            }
        }
        return longestPath;
    }

    private static int dfsPathFinding(int[][] giveMAtrix, int row, int col,int[][] memo) {
        if(memo[row][col] != 0){
            return memo[row][col];
        }
        int max =1;
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            //Check boundary
            if(newRow>=0 && newRow<giveMAtrix.length && newCol >=0 && newCol<giveMAtrix[0].length && giveMAtrix[newRow][newCol] > giveMAtrix[row][col]){
                int len = 1 + dfsPathFinding(giveMAtrix,newRow,newCol,memo);
                max = Math.max(max,len);
            }
        }
        memo[row][col] = max;
        return max;
    }
}
