package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        combinationSum(new int[]{2, 3, 6, 7},7);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        backTrackingCom(result,tempList,candidates,target,0,0);
        return result;
    }

    private static void backTrackingCom(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int target, int currentSum,int start) {
        if(currentSum>target){
            return;
        }else if(currentSum == target){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i=start;i<candidates.length;i++){
                tempList.add(candidates[i]);
                currentSum +=candidates[i];
                backTrackingCom(result,tempList,candidates,target,currentSum,i);
                currentSum -= candidates[i];
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
