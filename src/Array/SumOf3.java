package Array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SumOf3 {
    public static void main(String[] args) {
        int[] givenArray = {2, 3, 4, 1, 7, 9};
        findSum(givenArray,21);
    }

    private static void findSum(int[] array,int target){
        int left = 0;
        int right = array.length-1;
        Arrays.sort(array);
        for(int i=0;i<array.length-1;i++){
            left = i + 1;
            right = array.length - 1;
            while(left<right){
                int sumVal = array[left] + array[i]+array[right];
                if(sumVal == target){
                    System.out.println("available:"+array[left] +" "+ array[i]+" "+array[right]);
                    return;
                }else if(sumVal<target){
                    left++;
                }else if(sumVal>target){
                    right--;
                }
            }
        }
        System.out.println("Not avaialble");
    }
}
