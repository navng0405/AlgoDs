package Revist;

/**
 *
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "12+3-4+5";
        System.out.println(calculate(expression)); // Output: 16
    }

    private static int calculate(String expression) {
        int num = 0;
        int result = 0;
        int sign = 1;
        for(int i=0;i<expression.length();i++){
            char currentNum = expression.charAt(i);
            if(Character.isDigit(currentNum)){
                num = num*10+currentNum-'0';
            } else if (currentNum == '+') {
                result = result+sign*num;
                num=0;
                sign=1;
            } else if (currentNum == '-') {
                result = result+sign*num;
                num=0;
                sign=-1;
            }
        }
        result = result+sign*num;

        return result;
    }

}
