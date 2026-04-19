package Array;
/**
 * Two pointer
 */

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] givenArray = {1,1,2,3,4,4,6,7};
        System.out.println(Arrays.toString(removeDuplicates(givenArray)));
    }

    private static int[] removeDuplicates(int[] givenArray) {
        int i=0;
        for(int j=1;j<givenArray.length;j++){
            if(givenArray[i] != givenArray[j]){
                i++;
                givenArray[i]=givenArray[j];
            }
        }
        Arrays.copyOf(givenArray,i+1);

        return givenArray;
    }
}
