package Matrices;

public class DiagonalPrint {

    public static void printMatrixDiagonally(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;

        int N = matrix.length;
        int M = matrix[0].length;

        // There are (N+M-1) diagonals to be considered
        for (int line = 1; line <= (N + M - 1); line++) {
            /* Start column for the current line
             * Will be either the first column or the line number minus row count,
             * whichever is greater
             */
            int start_col = Math.max(0, line - N);

            /* Calculate count of elements in this line. The count of elements is
             * equal to minimum of line number, column-count-start_col and row-count
             */
            int count = Math.min(line, Math.min((M - start_col), N));

            for (int j = 0; j < count; j++) {
                int i = Math.min(N, line) - j - 1; // Calculate row index
                System.out.print(matrix[i][start_col + j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Matrix in Diagonal Pattern:");
        printMatrixDiagonally(matrix);
    }
}

