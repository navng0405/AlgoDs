package problems.Array;

import java.util.Arrays;

/**
 * i/p :  2 1 1 0 1 2 1 2 0 0 0 1
 *
 * o/p : 0 0 0 0 1 1 1 1 1  2 2 2
 *
 * 3 pts low mid high
 * 0 -> swap low,mid -> low++
 * 2- > swap mid, high -> high --
 * 1 -> no swap, mid++
 */

public class ArraySorting {
    public static void main(String args[]){
        int[] givenArray = {0,1,2,1,1,0,1,2,1,2,0,0,0,1};
        sortArray(givenArray);
    }

    private static void sortArray(int[] array){
        int low = 0, mid =0, high = array.length-1;
        while(mid<=high){
            if(array[mid] == 0){
                int temp = array[low];
                array[low] = array[mid];
                array[mid] = temp;
                low++;
                mid++;
            }else if(array[mid] == 2){
                int temp = array[high];
                array[high] = array[mid];
                array[mid] = temp;
                high--;
            }else{
                mid++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
