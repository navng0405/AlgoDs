package SlidingWindow;

/**
 * https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-minimum-window-subsequence
 */
public class MinSubsequence {
    public static String minWindow(String str1, String str2) {
        String minSeq="";
        int indexStr1 = 0;
        int indexStr2 = 0;
        int start=0;
        int minLen = Integer.MAX_VALUE;
        while(indexStr1<str1.length()){
            if(str1.charAt(indexStr1) == str2.charAt(indexStr2)){

                if(indexStr2 == 0){
                    start=indexStr1;
                }
                indexStr2++;
                if(indexStr2 == str2.length()){

                    if(minLen>indexStr1-start+1){
                        minLen = indexStr1-start+1;
                        minSeq = str1.substring(start,indexStr1+1);
                        System.out.println(minSeq);
                    }
                    indexStr2=0;
                    indexStr1=start;

                }
            }
            indexStr1++;
        }
        return minSeq;
    }

    public static void main(String[] args) {
        // Driver code
        String[] str1 = {
                "abcdedeaqdweq", "fgrqsqsnodwmxzkzxwqegkndaa", "zxcvnhss", "alpha", "beta"
        };
        String[] str2 = {
                "adeq", "kzed", "css", "la", "ab"
        };
        for (int i = 0; i < str1.length; i++) {
            System.out.println(i + 1 + ".\tInput String: " + "(" + str1[i] + ", " + str2[i] + ")");
            System.out.println("\tSubsequence string: " + minWindow(str1[i], str2[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
