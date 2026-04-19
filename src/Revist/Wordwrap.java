package Revist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Connecting words with '-' as blank spaces, no exceeds maxLength
 * e.g. ["1p3acres", "is", "a", "good", "place", "to", "communicate"],
 * 12 => {"1p3acres-is", "a-good-place", "for", "communicate"}
 *
 *
 *
 * Pt.2 Require every line to be "balanced".
 *
 * Input: String[] lines, ["the way it moves like me", "another sentence example",...], int maxLength.
 * Output: List lines.
 * 复制代码e.g. ["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 10 => {"123--45-67", "8901234", "5678-12345", "8-9-0-1-23"}
 * ["123 45 67 8901234 5678", "12345 8 9 0 1 23"], 15 => {"123----45----67", "8901234----567
 *
 */
public class Wordwrap {
    public static void main(String[] args) {
        String[] givenStringArray = {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        int maxLength = 12;
        List<String> wordWraps = getWordWraps(givenStringArray,maxLength);
        System.out.println(wordWraps);

        String[] givenStringArray1 = {"123 45 67 8901234 5678", "12345 8 9 0 1 23"};
        List<String> balancedWordWraps = getBalancedWordWrap(givenStringArray1,10);
        System.out.println(balancedWordWraps);
    }

    private static List<String> getBalancedWordWrap(String[] givenStringArray1, int maxLength) {
        List<String> balancedWordWrap = new ArrayList<>();
        List<String> currentWords = new ArrayList<>();
        int currentListWordsSize = 0;
        for(String word : givenStringArray1){
            String[] splitWords = word.split(" ");
            for(String splitWord : splitWords){
                if(currentListWordsSize+currentWords.size()+splitWord.length()>maxLength){
                    balancedWordWrap.add(balanceWords(currentWords, maxLength));
                    currentWords.clear();
                    currentListWordsSize=0;
                    currentWords.add(splitWord);
                    currentListWordsSize=splitWord.length();
                }else{
                    currentListWordsSize = currentListWordsSize+splitWord.length();
                    currentWords.add(splitWord);
                }
            }
        }

        if(currentWords.size()>0){
            balancedWordWrap.add(balanceWords(currentWords, maxLength));
        }
        return balancedWordWrap;
    }

    private static String balanceWords(List<String> currentWords,int maxLength) {
        int totalHypens = maxLength - currentWords.stream().mapToInt(String::length).sum();
        int gaps = currentWords.size()-1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<currentWords.size();i++){
            sb.append(currentWords.get(i));
            int appendHypends = gaps>0 ? (totalHypens+gaps-1)/gaps : totalHypens;
            char[] appends = new char[appendHypends];
            Arrays.fill(appends,'-');
            sb.append(appends);
            totalHypens = totalHypens-appendHypends;
            gaps--;
        }

        return sb.toString().replaceAll("-+$","");
    }


    private static List<String> getWordWraps(String[] givenStringArray, int maxLength) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int currentLength = 0;
        for(String word : givenStringArray){
            if(currentLength+(currentLength>0 ? 1 : 0)+word.length() > maxLength){
                result.add(sb.toString());
                sb = new StringBuilder(word);
                currentLength=0;
            }else{
                if(currentLength>0){
                    sb.append("-");
                }
                sb.append(word);
                currentLength = sb.length();

            }
        }
        if(currentLength>0){
            result.add(sb.toString());
        }
        return result;
    }
}
