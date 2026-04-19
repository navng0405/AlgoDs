package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] givenArray = {1,2,3};
        List<List<Integer>> subsets = getSubsets(givenArray);

    }

    private static List<List<Integer>> getSubsets(int[] givenArray) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrackingSubSet(givenArray,result,tempList,0);
        return result;
    }

    private static void backTrackingSubSet(int[] givenArray, List<List<Integer>> result, List<Integer> tempList, int start) {
        result.add(new ArrayList<>(tempList));
        for (int i=start;i<givenArray.length;i++){
            tempList.add(givenArray[i]);
            backTrackingSubSet(givenArray,result,tempList,i+1);
            tempList.removeLast();
        }
    }
}
