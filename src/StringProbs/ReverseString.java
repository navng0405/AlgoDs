package StringProbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseString {
    public static void main(String[] args) {
        List<String> givenStringList = new ArrayList<>();
        givenStringList.add("word");
        givenStringList.add("king");

        reverseList(givenStringList);
    }

    private static void reverseList(List<String> givenStringList) {
        for(String word : givenStringList){
            System.out.println(reverseString(word));
        }
    }

    private static String reverseString(String word) {
        int left = 0;
        int right = word.length()-1;
        char[] wordArray = word.toCharArray();
        while(left<right){
            char temp = wordArray[left];
            wordArray[left] = wordArray[right];
            wordArray[right]=temp;
            left++;
            right--;
        }
        return new String(wordArray);
    }
}
