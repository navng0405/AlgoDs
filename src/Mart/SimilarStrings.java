package Mart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SimilarStrings {
    public static void main(String[] args) {
        String[] words = {"abc","bca","aabbcc","xyz","yzx"};
        System.out.println("Number of similar pairs :" + countSimilarPairs(words));
    }

    private static Integer countSimilarPairs(String[] words) {
        Set[] temp = new Set[words.length];
        for(int i=0;i<words.length;i++){
            temp[i] = new HashSet();
            for(int j=0;j<words[i].length();j++){
                temp[i].add(words[i].charAt(j));
            }
        }
        int similarPair = 0;
        for(int i=0;i<temp.length;i++){
            for(int j=i+1;j<temp.length;j++){
                if(temp[i].equals(temp[j])){
                    similarPair++;
                }
            }
        }

        return similarPair;
    }


}
