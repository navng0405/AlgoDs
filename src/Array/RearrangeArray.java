package Array;

import java.util.Arrays;

/**
 * Rearrange Array such that arr[i] >= arr[j] if i is even and arr[i] <= arr[j] if i is odd and j < i
 *
 * https://tutorialcup.com/interview/array/rearrange-array-such-that-arri-arrj-if-i-is-even-and-arri.htm
 *
 * Copy given array to temp
 * Sort it
 * Copy first odd position data to Original array in alternate position
 * copy even to remaining
 */
public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr = { 1,4,6,2,4,8,9,10};
        int size =arr.length;
        rearrangeArrayEvenOdd (arr, size);
    }

    private static void rearrangeArrayEvenOdd(int[] arr, int size) {
        int[] temp = Arrays.copyOf(arr, size);
        Arrays.sort(temp);
        int evenPosition = size/2;
        int oddPosition = size-evenPosition;

        int j=oddPosition-1;
        for(int i=0;i<size;i=i+2){
            arr[i] = temp[j];
            j--;
        }
        j=oddPosition;
        for(int i=1;i<size;i=i+2){
            arr[i] = temp[j];
            j++;
        }
        for (int i:arr){
            System.out.println(i);
        }
    }

}
