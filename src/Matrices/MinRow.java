package Matrices;

public class MinRow {
    static int minRow(int A[][]) {
        // code here
        int rowBegin = 0;
        int colBegin = 0;
        int rowEnd = A.length-1;
        int colEnd = A[0].length-1;
        int count=Integer.MAX_VALUE;
        int rowNum = 0;
        for(int i=rowBegin;i<=rowEnd;i++){
            int countHere = 0;
            for(int j=colBegin;j<=colEnd;j++){
                if(A[i][j] == 1){
                    countHere = countHere+1;
                }
            }
            if(countHere<count){
                rowNum = i+1;
                count = countHere;
            }
        }
        return rowNum == 0 ? 1 : rowNum;

    }

    public static void main(String[] args) {
        int[][] inputMatrix = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        System.out.println(minRow(inputMatrix));
    }
}
