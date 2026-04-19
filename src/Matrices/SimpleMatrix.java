package Matrices;

import Array.Reverse;

public class SimpleMatrix {
    public static void main(String[] args) {
        int[][] givenMatrix = {{1,2,3,5},{4,5,6,10},{7,8,9,15}};

        for(int row=0;row<givenMatrix.length;row++){
            for(int col=0;col<givenMatrix[0].length;col++){
                System.out.print(givenMatrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println( " Transpose");



        int totalRow = givenMatrix.length;

        //Step 1 : Transpose the given matrix
        for(int row=0;row<totalRow;row++){
            for(int col=row;col<totalRow;col++){
                int temp = givenMatrix[row][col];
                givenMatrix[row][col] = givenMatrix[col][row];
                givenMatrix[col][row] =temp;
            }
        }

        printMatrix(givenMatrix);
        System.out.println("Reverse every row");



        //Reverse every row of given MAtrix

        for(int row=0;row<totalRow;row++){
            int start =0;
            int end = totalRow-1;
            //Reverse
            while(start<end){
                int temp = givenMatrix[row][start];
                givenMatrix[row][start] = givenMatrix[row][end];
                givenMatrix[row][end] = temp;
                start++;
                end--;
            }

        }
        printMatrix(givenMatrix);



    }

    public static void printMatrix(int[][] givenMatrix){
        for(int row=0;row<givenMatrix.length;row++){
            for(int col=0;col<givenMatrix[0].length;col++){
                System.out.print(givenMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }



    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        int rows = matrix.length, cols = matrix[0].length;

        // Check if first row or first column has a zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) firstColZero = true;
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) firstRowZero = true;
        }

        // Use first row and column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Zero out cells based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Handle first row and column based on flags
        if (firstColZero) {
            for (int i = 0; i < rows; i++) matrix[i][0] = 0;
        }
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) matrix[0][j] = 0;
        }
    }

}
