package Matrices;



public class LeftRotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        int N = 3, M = 4, K = 2; // Example values

        System.out.println("Original Matrix:");
        printMatrix(matrix, N, M);

        leftRotateMatrix(matrix, N, M, K);

        System.out.println("Matrix after " + K + " left rotations:");
        printMatrix(matrix, N, M);
    }

    private static void leftRotateMatrix(int[][] matrix, int rowLength, int colLength, int k) {
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = rowLength-1;
        int colEnd = colLength-1;
        k=k%colLength;

        for(int row=rowBegin;row<=rowEnd;row++){
            for(int j=0;j<k;j++){
                int firstElement = matrix[row][0];
                for(int col=colBegin;col<colEnd;col++){
                    matrix[row][col]= matrix[row][col+1];
                }
                matrix[row][colEnd]=firstElement;
            }
        }
    }

    public static void printMatrix(int[][] matrix, int N, int M) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
