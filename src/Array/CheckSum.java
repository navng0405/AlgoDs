package Array;

import java.util.HashMap;
import java.util.Map;

public class CheckSum {
    public static void main(String[] args) {
        int givenArray[] = {-2,11,6,4,8,9};
        int magicNumber = 9;
        checkSum(givenArray,magicNumber);
    }

    private static void checkSum(int givenArray[],int target){
        Map<Integer,Integer> dic = new HashMap<>();
        for(int i=0;i<givenArray.length;i++){
            int complement = target-givenArray[i];
            if(dic.containsKey(complement)){
                System.out.println(complement + ","+givenArray[i]);
            }else{
                dic.put(givenArray[i],i);
            }
        }
        System.out.println("No value");
    }
}
