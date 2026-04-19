package Revist;

public class ZeroAreaFinder {
    public static void main(String[] args) {
        int[][] givenArray = {{0,1,1},{0,0,1},{1,0,0}};
        System.out.println(allPath(givenArray));
    }

    private static boolean allPath(int[][] givenArray) {
        int rowLength = givenArray.length;
        int colLength = givenArray[0].length;

        boolean[][] visited = new boolean[rowLength][colLength];
        dfsVisit(givenArray,visited,1,1);

        for(int row=0;row<givenArray.length;row++){
            for (int col=0;col<givenArray[0].length;col++){
                if(givenArray[row][col] == 0 && !visited[row][col]){
                    return false;
                }
            }
        }

        return true;
    }

    private static void dfsVisit(int[][] givenArray, boolean[][] visited, int startRow, int startCol) {
        if(startRow<0 || startRow>=givenArray.length || startCol<0 || startCol>=givenArray[0].length || givenArray[startRow][startCol] != 0 || visited[startRow][startCol]){
            return;
        }

        visited[startRow][startCol] = true;

        dfsVisit(givenArray,visited,startRow-1,startCol);
        dfsVisit(givenArray,visited,startRow+1,startCol);
        dfsVisit(givenArray,visited,startRow,startCol-1);
        dfsVisit(givenArray,visited,startRow,startCol+1);
    }
}
