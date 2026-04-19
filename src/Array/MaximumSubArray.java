package Array;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] givenArray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(getMaxSubArray(givenArray));
    }

    private static int getMaxSubArray(int[] givenArray){
        if(givenArray ==null || givenArray.length == 0){
            return 0;
        }
        int max_soFar = givenArray[0];
        int max_EndingHere = givenArray[0];
        for(int i=1;i<givenArray.length;i++){
            max_EndingHere = Math.max(givenArray[i],max_EndingHere+givenArray[i]);
            max_soFar = Math.max(max_EndingHere,max_soFar);
        }
        return max_soFar < 0 ? 0 : max_soFar;
    }
}
