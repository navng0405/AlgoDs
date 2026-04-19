package problems.Array;

import java.util.Arrays;

/** Find next greatest number by using same digits
 * I/p : 218765 -> 251678
 * o/p : find which element is smaller than next element - > 1,8
 * swap 1 with smaller number in right -> 1 with 5
 * Arrays.sort(8->1)
 */
public class ArrayNextGreater {
    public static void main(String args[]){
        int[] givenArray = {2,1,8,7,6,5};
        findNextGreatestNumber(givenArray);
    }
    private static void findNextGreatestNumber(int[] array){
        int element = 0;
        int i = 0;
        for( i = array.length-1; i>0; i--){
            if(array[i]>array[i-1]){

                break;
            }
        }
        element = array[i-1];
        int min = i;
        for(int j=i+1;j<array.length;j++){
            if(array[j]>element && array[j]<array[min]){
                min=j;
            }
        }
        int temp = array[min];
        array[min]=element;
        array[i-1]=temp;
        Arrays.sort(array,i,array.length);
        System.out.println(Arrays.toString(array));

        String str = "Naveen";
        str.toLowerCase();

    }
}
