package StringProbs;

import java.util.Arrays;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCounts = new int[124]; // Assuming the strings contain only lowercase alphabets
        for(int i=0;i<s.length();i++){
            int a = s.charAt(i)-'a';
            //int a = s.charAt(i)-'0';
            charCounts[a] = charCounts[a]+1;
            charCounts[t.charAt(i)-'a'] = charCounts[t.charAt(i)-'a']-1;
        }

        for(int i:charCounts){
            if(i != 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "naveen", t = "eennav";
        System.out.println("Is Anagram: " + isAnagram(s, t));
        isAnagram2();
    }


    private static boolean isAnagram2(){
        String s1 = "naveen";
        String s2 = "navene";
        char[] sortedString1 = s1.toCharArray();
        char[] sortedString2 = s2.toCharArray();
        Arrays.sort(sortedString1);
        Arrays.sort(sortedString2);
        for(int i=0;i<sortedString2.length;i++){
            if(sortedString1[i] != sortedString2[i]){
                System.out.println(" Not Anagrams");
                return false;
            }
        }
        System.out.println("Given strings are anagrams");
        return true;
    }
}

class Reservation {
    private String customerName;
    private int numberOfGuests; //
    //constructor and get methods are defined
}

