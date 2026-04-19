package BackTracking;

import java.util.*;

public class PatitionString {
    public static void main(String[] args) {
        String givenString = "aab";
        for(List<String> stringlist : partitionStringPalindrome(givenString)){
            System.out.println(stringlist.toString());
        }

    }

    private static List<List<String>> partitionStringPalindrome(String givenString) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        backTracking(result,tempList,givenString,0);
        return result;
    }

    private static List<List<String>> backTracking(List<List<String>> result, List<String> tempList, String givenString, int start) {
        if(givenString.length() == start){
            result.add(new ArrayList<>(tempList));
        }else{
            for(int i=start;i<givenString.length();i++){
                if(isPalindrome(givenString,start,i)){
                    tempList.add(givenString.substring(start,i+1));
                    backTracking(result,tempList,givenString,i+1);
                    tempList.remove(tempList.size()-1);
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String givenString, int left, int right) {
        while(left<right){
            if(givenString.charAt(left) != givenString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


}
