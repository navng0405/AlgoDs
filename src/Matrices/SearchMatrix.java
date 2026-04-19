package Matrices;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        boolean found = binarySearch(matrix,10);
        System.out.println(found);
    }


    private static boolean search(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }

        int rowBegin = 0,rowEnd = matrix.length-1;
        int colBegin = 0,colEnd = matrix[0].length-1;
        while(rowBegin<=rowEnd && colEnd>=colBegin){
            if(matrix[rowBegin][colEnd] == target){
                return true;
            }else if(matrix[rowBegin][colEnd]>target){
                colEnd--;
            }else{
                rowBegin++;
            }
        }
        return false;
    }

    //Binary Search
    private static boolean binarySearch(int[][] matrix,int target){
        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        int low = 0;
        int high = rowLength*colLength-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midValue = matrix[mid/colLength][mid%colLength];
            if(midValue == target){
                return true;
            }else if(midValue < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }

        return false;
    }
}
