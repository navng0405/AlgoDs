package StringProbs;

import java.util.Stack;

public class DeleteConsecutiveWords {

    public static void main(String[] args) {
        String sequence = "I love love to to to code";
        System.out.println(deleteConsecutiveWords(sequence));
        // Output: "I to code"
    }

    private static String deleteConsecutiveWords(String sequence) {
        String[] splitWords = sequence.split("\\s+"); //Split the sequence into words

        Stack<String> tempStore = new Stack<>();
        for(String word : splitWords){
            if(!tempStore.isEmpty() && tempStore.peek().equals(word)){
                tempStore.pop();
            }else{
                tempStore.push(word);
            }
        }

        StringBuilder result = new StringBuilder();
        for(String word : tempStore){
            result.append(word).append(" ");
        }
        return result.toString();
    }


}
