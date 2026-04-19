package Matrices;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {


    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;

        int rowBegin = 0, rowEnd = matrix.length - 1;
        int colBegin = 0, colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                result.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                result.add(matrix[j][colEnd]);
            }
            colEnd--;

            // Traverse Left
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    result.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            // Traverse Up
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j--) {
                    result.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        System.out.println("Spiral Order: " + spiralOrder(matrix));
    }
}
