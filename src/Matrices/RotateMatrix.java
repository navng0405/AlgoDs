package Matrices;

public class RotateMatrix {

    public static void rotateMatrix(int[][] matrix) {
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;
        int row = 0;
        int col = 0;
        int previous;
        int current;
        while(row<totalRow && col<totalCol){
            //Base Case
            if(row == totalRow || col == totalCol){
                break;
            }

            previous = matrix[row+1][col];

            //Move left to right
            for(int i=col;i<totalCol;i++){
                current = matrix[row][i];
                matrix[row][i] = previous;
                previous = current;
            }
            row++;

            for(int i=row;i<totalRow;i++){
                current = matrix[i][totalCol-1];
                matrix[i][totalCol-1] = previous;
                previous = current;
            }

            totalCol = totalCol-1;
            if(row<totalRow){
                for(int i =totalCol-1;i>=col;i--){
                    current = matrix[totalRow-1][i];
                    matrix[totalRow-1][i] = previous;
                    previous = current;
                }
            }

            totalRow = totalRow-1;
            if(col<totalCol){
                for(int i=totalRow-1;i>=row;i--){
                    current = matrix[i][col];
                    matrix[i][col]=previous;
                    previous=current;
                }
            }

            col++;

        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotateMatrix(matrix);

        // Code to print the rotated matrix
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
