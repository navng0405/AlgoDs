package BackTracking;

import java.util.*;

public class PhoneLetterCombination {
    public static void main(String[] args) {
        Map<Integer,String> DIAL_PAD_MAP = new HashMap<>();
        DIAL_PAD_MAP.put(1, "");
        DIAL_PAD_MAP.put(2, "ABC");
        DIAL_PAD_MAP.put(3, "DEF");
        DIAL_PAD_MAP.put(4, "GHI");
        DIAL_PAD_MAP.put(5, "JKL");
        DIAL_PAD_MAP.put(6, "MNO");
        DIAL_PAD_MAP.put(7, "PQRS");
        DIAL_PAD_MAP.put(8, "TUV");
        DIAL_PAD_MAP.put(9, "WXYZ");
        DIAL_PAD_MAP.put(0, "+");
        int[] typeNum = {2,3};
        combination(DIAL_PAD_MAP,typeNum);
    }

    private static Set<String> combination(Map<Integer, String> dialMap, int[] typeNum) {
        Set<String> result = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        backTrackingLetter(dialMap,typeNum,result,temp,0,0);
        return result;

    }

    private static void backTrackingLetter(Map<Integer, String> dialMap, int[] typeNum, Set<String> result, StringBuilder temp, int start,int inputIdex) {
        //Base Case
        if(temp.length()==typeNum.length){
            result.add(temp.toString());
            return;
        }else{
            int digit = typeNum[inputIdex];
            String letters = dialMap.get(digit);
            for(int i=0;i<letters.length();i++){
                temp.append(letters.charAt(i));
                backTrackingLetter(dialMap,typeNum,result,temp,i,inputIdex+1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
}
