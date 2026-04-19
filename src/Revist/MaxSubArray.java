package Revist;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] givenArrray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSum(givenArrray));
    }

    private static int getMaxSum(int[] arr){
        if(arr.length == 0){
            return 0;
        }

        int max_endingHere =0;
        int max_SoFar = 0;
        for(int i=0;i<arr.length;i++){
            max_endingHere = Math.max(arr[i],max_endingHere+arr[i]);
            max_SoFar = Math.max(max_SoFar,max_endingHere);
        }
        return max_SoFar;
    }
}
