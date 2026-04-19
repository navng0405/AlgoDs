package Matrices;

public class MatrixTraversal {
    public static void main(String[] args) {
        int[][] inputMatrix = {{1,2,3},{4,5,6},{7,8,9}};
        printMatrix(inputMatrix,0,0);
    }

    //Function to print matrix values
    static void printMatrix(int[][] inputMatrix, int row, int column) {
        int totalRow = inputMatrix.length;
        int totalCol = inputMatrix[0].length;

        //Base CAse
        if(row>=totalRow || column>=totalCol){
            return;
        }

        //Print the current element
        System.out.print(inputMatrix[row][column] + " ");

        //Move to the next Column
        if(column<totalCol-1){
            printMatrix(inputMatrix,row,column+1);
        }else if(row<totalRow-1){ //Move to the next row if this the last Column
            System.out.println();
            printMatrix(inputMatrix,row+1,0);
        }

    }
}
