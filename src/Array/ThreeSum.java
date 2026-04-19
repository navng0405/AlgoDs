package Array;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> triplets = getThreeSumm(nums);
        System.out.println(Arrays.asList(triplets));
    }

    private static List<List<Integer>> getThreeSumm(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //Also check nums.length-2 ------>
        for(int i=0;i<nums.length-2;i++){
            //Why we need to check i==0 because first element , we dont wanna check duplicates
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                int left = i+1;
                int right = nums.length -1;
                int sum = 0-nums[i];
                while(left<right){
                    if(nums[left]+nums[right] == sum){
                        result.add(Arrays.asList(nums[left],nums[i],nums[right]));
                        while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]<sum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}


