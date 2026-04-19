package StringProbs;

import java.util.Arrays;

public class Zigzag {
    public static void main(String[] args) {
        String givenString = "PAYPALISHIRING";
        int rows = 3;
        System.out.println(zizgagPattern(givenString,rows));
    }

    private static String zizgagPattern(String givenString,int givenRows) {
        boolean goingDown = true;
        int rows=0;
        String[] result = new String[givenRows];
        Arrays.fill(result,"");
        for(int i=0;i<givenString.length();i++){
            result[rows] = result[rows]+givenString.charAt(i);
            if(rows==0){
                goingDown=true;
            }
            if(rows == givenRows-1){
                goingDown=false;
            }
            if(goingDown){
                rows++;
            }else {
                rows--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : result){
            stringBuilder.append(word);
        }
        return stringBuilder.toString();
    }
}
