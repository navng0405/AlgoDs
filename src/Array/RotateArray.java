package Array;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        int k = 2;
        System.out.println(Arrays.toString(rotateArray(arr,k)));
    }

    private static int[] rotateArray(int[] arr, int k) {
        k = k % arr.length;
        arr = rotateArrayUtil(arr,0,arr.length-1);
        arr = rotateArrayUtil(arr,0,k-1);
        arr = rotateArrayUtil(arr,k,arr.length-1);
        return arr;
    }

    private static int[] rotateArrayUtil(int[] arr, int start, int end) {
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;

    }
}
