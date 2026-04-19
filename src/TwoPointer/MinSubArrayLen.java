package TwoPointer;

/**
 * Two pointer + Sliding window
 */
public class MinSubArrayLen {
    public static void main(String[] args) {


        int[] givenArray = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLan(givenArray,target));

    }

    private static int minSubArrayLan(int[] givenArray,int target){
        int result = Integer.MAX_VALUE;
        int sum=0;
        int start=0;
        for(int end=0;end<givenArray.length;end++){
            sum = sum+givenArray[end];
            while(sum>=target){
                result = Math.min(result,end-start+1);
                sum = sum - givenArray[start++];

            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
