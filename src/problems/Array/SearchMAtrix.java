package problems.Array;

class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 60;
        System.out.println("Target found: " + searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int left=0;
        int right = rowLength*colLength-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midValue = matrix[mid/colLength][mid%rowLength]; //
            if(target == midValue){
                return true;
            }else if(target<midValue){
                right=mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;

    }

}
