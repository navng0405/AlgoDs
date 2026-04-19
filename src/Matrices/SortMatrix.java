package Matrices;

import java.util.Arrays;

public class SortMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 11, 8},
                {9, 10, 7, 12},
                {13, 14, 15, 16}
        };

        sortMatrics(matrix);

        // Code to print the rotated matrix
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static void sortMatrics(int[][] matrix) {
        //Must initialize variables
        int totalRow = matrix.length;
        int totalCol = matrix[0].length;

        //Use Extra space
        int[] temp = new int[totalRow*totalCol];
        int k=0;
        for(int i=0;i<totalRow;i++){
            for(int j=0;j<totalCol;j++){
                temp[k++] = matrix[i][j];
            }
        }

        Arrays.sort(temp);
        k=0;
        for(int i=0;i<totalRow;i++){
            for(int j=0;j<totalCol;j++){
                matrix[i][j] = temp[k++];
            }
        }
    }
}
