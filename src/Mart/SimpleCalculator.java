package Mart;

public class SimpleCalculator {
    public static void main(String[] args) {
        String expression = "12+3-4+5";
        System.out.println(calculate(expression)); // Output: 16
    }

    private static int calculate(String expression) {
        int num = 0;
        int result = 0;
        int sign =1; // 1 for plus and -1 for minus
        for(char c : expression.toCharArray()){
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }else if(c == '+'){
                result = result + sign*num;
                num = 0;
                sign=1;
            }else if(c == '-'){
                result = result + sign*num;
                num = 0;
                sign=-1;
            }
        }
        result= result + sign*num;
        return result;
    }
}
