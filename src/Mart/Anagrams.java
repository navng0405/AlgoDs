package Mart;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Appoarch :
 * Iterate String array and get each word then Sort it, then store it into Map oe set to store
 * then return size of the set
 */
public class Anagrams {
    public static void main(String[] args) {
        String[] words = {"cat","listen","silent","kitten","salient"};
        System.out.println("Number of grouped Anagrams : " + getGroupedAnagrams(words));
    }

    private static int getGroupedAnagrams(String[] words) {
        Set<String> temp = new HashSet<>();
        for(String word : words){
            char[] charecters = word.toCharArray();
            Arrays.sort(charecters);
            String sortedWord = new String(charecters);
            System.out.println(sortedWord);
            temp.add(sortedWord);

        }
        return temp.size();
    }
}
