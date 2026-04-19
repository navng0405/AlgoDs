package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupletsSum {
    public static void main(String[] args) {
        int[] givenArray = {1, 0, -1, 0, -2, 2};
        int target = 0;
        System.out.println(getQuadruplets(givenArray,target));
    }

    private static List<List<Integer>> getQuadruplets(int[] givenArray, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int sum = 0;
        for(int i=0;i<givenArray.length-3;i++){
            //Check duplicates
            if((i == 0) || (i>0 && givenArray[i] != givenArray[i-1])){
                for(int j=i+1;j<givenArray.length-1;j++){
                    //Check duplicates
                    if(j>i+1 && givenArray[j] != givenArray[j-1]){
                        int left = j+1;
                        int right = givenArray.length-1;
                        while (left<right){
                            sum = givenArray[i] + givenArray[j] + givenArray[left] + givenArray[right];
                            if(sum == target){
                                result.add(Arrays.asList(givenArray[i], givenArray[j], givenArray[left] ,givenArray[right]));
                                while (left<right && givenArray[left] == givenArray[left++]) left++;
                                while (left<right && givenArray[right] == givenArray[right--]) right--;
                            }else if(sum>givenArray[i] + givenArray[j] + givenArray[left] + givenArray[right]){
                                left++;
                            }else{
                                right--;
                            }

                        }
                    }
                }
            }
        }
        return result;
    }
}
