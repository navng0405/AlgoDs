package StringProbs;

import java.util.Arrays;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums)); // Output: "9534330"
    }

    private static String largestNumber(int[] nums) {
        String[] convertString = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            convertString[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(convertString, (a, b) -> {
            String order1 = a+b;
            String order2 = b+a;
            return order2.compareTo(order1);
        });

        if(convertString[0].equals("0")){
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for(String val : convertString){
            result.append(val);
        }

        return result.toString();
    }
}
