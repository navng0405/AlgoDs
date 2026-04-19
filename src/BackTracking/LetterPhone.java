package BackTracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LetterPhone {


    // Phone number mapping
    private static Map<Integer, String> DIAL_PAD_MAP = new HashMap<>();
    static {
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
    }


    public static void main(String... args) {

        // Test phone number (408) 215-5012
        int[] testPhoneNumber = new int[] {4,0,8};
        LetterPhone generator1 = new LetterPhone();
        Set<String> results = generator1.generateAllWords(testPhoneNumber);
        System.out.println("Result:");
        results.forEach(x -> System.out.println(x));
    }

    private Set<String> generateAllWords(int[] inputNumber) {
        Set<String> result = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        helper(inputNumber,result,sb,0);
        // Your awesome implementation goes here
        return result;
    }

    private void helper(int[] inputNumber,Set<String> result,StringBuilder sb,int index){
        //base case
        if(sb.length() == inputNumber.length){
            result.add(sb.toString());

            return;
        }

        int digit = inputNumber[index]; //4
        String letter = DIAL_PAD_MAP.get(digit);
        for(int i=0;i<letter.length();i++){

            sb.append(letter.charAt(i));
            helper(inputNumber,result,sb,index+1);
            //System.out.println(sb.toString());
            sb.deleteCharAt(sb.length()-1);

        }


    }
}


