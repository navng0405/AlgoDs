package Mart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * HackerLand's highstreet has a number of skyscrapers of different heights. A contiguous sequence of buildings is called a "step pattern" if for every building of that contiguous sequence (or subarray), the height of that building is 1 less than the height of the building on its
 * immediate left, i.e., heighti] = height[i - 1] -1, for all 0< i< length of the subarray in consideration.
 * The task is to find the number of contiguous sequences of the buildings that are "step patterns".
 * Example
 * Given, n= 5 and array heights = [5, 4, 3, 1, 5].
 * There are 3 valid "step patterns" in heights.
 * The subarray (5, 4), 4 = 5 - 1.
 * The subarray [4, 3], 3 = 4-1.
 * The subarray [5, 4, 3], 4 = 5 - 1 and 3 - 4 - 1.
 * Subarray [4, 3, 11 is not valid as for index 2 of the subarray 3 - 1 ÷ 1.
 * Function Description
 * Complete the function count Steps in the editor below. The function must return a long integer that denotes the number of contiguous sequences (subarrays) of buildings that are "step patterns". countSteps has the following parameter:
 * heights[heights[0]...heights[n-1]J: an array of integers.
 */
public class Skyscrapers {
    public static void main(String[] args) {
        List<Integer> givenArray = new ArrayList<>(Arrays.asList(5,4,3,1,5,4));
        System.out.println("Get count of Sky Scrapers :" + getCount(givenArray));
        
    }

    private static Integer getCount(List<Integer> givenArray) {
        int stepPatternCount = 0;
        int consecutiveSteps = 0;
        for(int i=1;i<givenArray.size();i++){
            if(givenArray.get(i) == givenArray.get(i-1)-1){
                consecutiveSteps = consecutiveSteps+1;
                stepPatternCount = stepPatternCount + consecutiveSteps;
            }else{
                consecutiveSteps = 0; // pattern broken
            }
        }

        return stepPatternCount;
    }

}
