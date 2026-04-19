package Mart;

import java.util.ArrayList;
import java.util.List;

public class ZeroRowsColsFinder {

    public static List<List<Integer>> findZeroRowsCols(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        boolean[] zeroRows = new boolean[numRows]; // Tracks rows filled with 0s
        boolean[] zeroCols = new boolean[numCols]; // Tracks columns filled with 0s

        // Initialize arrays to true, and then set to false if a non-zero is found
        for (int i = 0; i < numRows; i++) {
            zeroRows[i] = true;
        }
        for (int j = 0; j < numCols; j++) {
            zeroCols[j] = true;
        }

        // Iterate through the matrix to update zeroRows and zeroCols
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != 0) {
                    zeroRows[i] = false;
                    zeroCols[j] = false;
                }
            }
        }

        // Collect indices of rows and columns that are all zeros
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (zeroRows[i]) {
                rows.add(i);
            }
        }
        for (int j = 0; j < numCols; j++) {
            if (zeroCols[j]) {
                cols.add(j);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(rows);
        result.add(cols);
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0, 0,0},
                {0, 0, 0, 0,0},
                {1, 0, 1, 1,0},
                {0, 0, 0, 0,0}
        };

        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                if(matrix[row][col] == 0 && (row ==0 || col ==0)){
                    int tempRow = row;
                    int tempCol = col;
                    while(tempRow<matrix.length){
                        tempRow++;
                    }
                    if(tempRow == matrix.length){
                        System.out.println(tempRow);
                    }
                    while(tempCol<matrix[0].length){
                        tempCol++;
                    }
                    if(tempCol == matrix[0].length){
                        //System.out.println(tempCol--);
                    }
                }
            }
        }

        //List<List<Integer>> zeroRowsCols = findZeroRowsCols(matrix);
        //List<List<Integer>> zeroRowsCols1 = findZeroRowsColsMy(matrix);
        //System.out.println("Rows with all 0s: " + zeroRowsCols.get(0));
       //System.out.println("Cols with all 0s: " + zeroRowsCols.get(1));


        //System.out.println("Rows with all 0s: " + zeroRowsCols1.get(0));
        //System.out.println("Cols with all 0s: " + zeroRowsCols1.get(1));
    }

    private static List<List<Integer>> findZeroRowsColsMy(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        List<List<Integer>> rowList = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();


        for(int row=0;row<rowLength;row++){
            if(matrix[row][0] == 0){
                int col = 1;
                while(col<colLength && matrix[row][col] == 0){
                    col++;
                }
                if(col == colLength){
                   // System.out.println(row);
                    rows.add(row);
                }
            }
        }

        for(int col=0;col<colLength;col++){
            if(matrix[0][col] == 0){
                int row = 1;
                while(row<rowLength && matrix[row][col] == 0){
                    row++;
                }
                if(row == rowLength){
                    //System.out.println(col);
                    cols.add(col);
                }
            }
        }
        rowList.add(rows);
        rowList.add(cols);

        return rowList;
    }


}

