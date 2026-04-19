package Array;

import java.util.HashMap;
import java.util.Map;

public class LenOfLongSubarr {

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        int maxLength = 0;
        int sum =0;
        Map<Integer,Integer> temp = new HashMap<>();
        //Array starts from 0
        temp.put(0,-1);
        for(int i=0;i<A.length;i++){
            sum = sum+A[i];
            if(!temp.containsKey(sum)){
                temp.put(sum,i);
            }
            if(temp.containsKey(sum-K)){
                maxLength = Math.max(maxLength,i-temp.get(sum-K));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr1 = {-13,0,6,15,16,2,15,-12,17,-16,0,-3,19,-3,2,-9,-6};

        System.out.println("Kth element: " + lenOfLongSubarr(arr1, 17,15));
    }
}
