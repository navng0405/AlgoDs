package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] givenArray = {3,2,1};
        System.out.println(checkDuplicates(givenArray));
    }

    private static boolean checkDuplicates(int[] givenArray) {
        Set<Integer> myset = new HashSet<>();
        for(int i=0;i<givenArray.length;i++){
            if(myset.contains(givenArray[i])){
                return false;
            }else{
                myset.add(givenArray[i]);
            }
        }
        return true;
    }


}
