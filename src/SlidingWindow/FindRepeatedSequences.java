package SlidingWindow;

import java.util.*;

public class FindRepeatedSequences{

    public static Set<String> findRepeatedSequences(String s, int k) {

        // Replace this placeholder return statement with your code
        Map<String,Integer> dic = new HashMap<>();
        Set<String> result = new HashSet<>();
        int i=0;
        while(i+k<=s.length()){
            String tmp = s.substring(i,i+k);
            dic.put(tmp,dic.getOrDefault(tmp,0)+1);
            if(dic.get(tmp) == 2){
                result.add(tmp);
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        String input = "AAAAACCCCCAAAAACCCCCC";
        System.out.println(findRepeatedSequences(input,8));
    }
}
