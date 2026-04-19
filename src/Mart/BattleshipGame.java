package Mart;

import java.util.Arrays;
import java.util.Random;

public class BattleshipGame {
    static int gridSize;
    static char[][] grid;
    static char[][] target;
    BattleshipGame (int gridSize){
        BattleshipGame.gridSize = gridSize;
        grid = new char[gridSize][gridSize];
        target = new char[gridSize][gridSize];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = '.';
                target[i][j] = '0';
            }
        }
    }

    private static void print(){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void placeShip(){
        Random rand = new Random();
        int row;
        int col;
        boolean isVertical = rand.nextBoolean();

        if(isVertical){
            row = rand.nextInt(gridSize-5);
            col = rand.nextInt(gridSize);
            for(int i=row;i<row+5;i++){
                grid[i][col] = 'x';
            }
        }else {
            row = rand.nextInt(gridSize);
            col = rand.nextInt(gridSize-5);
            for(int i=col;i<col+5;i++){
                grid[row][i] = 'x';
            }
        }
    }

    public static void main(String[] args) {
        BattleshipGame battleshipGame = new BattleshipGame(10);
        print();
        System.out.println();
        battleshipGame.placeShip();
        print();
        battleshipGame.placeShip();
        System.out.println();
        print();
        for(int i=0;i<20;i++){
            selectTarget();
        }
        smartTarget();
    }

    private static void selectTarget() {
        Random random = new Random();
        int row= random.nextInt(gridSize);
        int col = random.nextInt(gridSize);

        if(target[row][col] == '0'){
            target[row][col] = grid[row][col] == 'x' ? 'H' : 'M';

        }

        printTarget();
    }

    private static void printTarget() {
        System.out.println();
        for(int i=0;i<gridSize;i++){
            for(int j=0;j<gridSize;j++){
                System.out.print(target[i][j] == 0 ? '.' : target[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void smartTarget(){
        for(int row=0;row<gridSize;row++){
            for(int col=0;col<gridSize;col++){
                if(target[row][col] == 'H'){
                    targetSurroundings(row,col);
                    return;
                }
            }
        }


    }

    private static void targetSurroundings(int row, int col) {
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] newValues: directions){
            int newRow = row+newValues[0];
            int newCol = col+newValues[1];
            if(newRow >=0 && newRow <gridSize && newCol>=0 && newCol<gridSize && target[newRow][newCol] == '0'){
                selectSpecificTarget(newRow,newCol);
            }
        }
    }

    private static void selectSpecificTarget(int newRow, int newCol) {
        if(grid[newRow][newCol] == 'x'){
            target[newRow][newCol] = 'H';
        }else{
            target[newRow][newCol] = 'M';
        }

        printTarget();
    }
}
