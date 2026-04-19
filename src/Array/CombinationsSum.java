package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = getCombinations(candidates,target);
        System.out.println(result);
    }

    private static List<List<Integer>> getCombinations(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        int sum=0;
        backTracking(candidates,target,result,tempList,sum,0);
        return result;
    }

    private static void backTracking(int[] inputArray,int target,List<List<Integer>> result,List<Integer> tempList,int sum,int index){
        //Base Case
        if(sum>target){
            return;
        }

        if(sum == target){
            List<Integer> newList = new ArrayList<>(tempList);
            result.add(newList);
            return;
        }

        for(int i=index;i<inputArray.length;i++){
            tempList.add(inputArray[i]);
            backTracking(inputArray,target,result,tempList,sum+inputArray[i],i);
            tempList.remove(tempList.size()-1);
        }
    }


}

