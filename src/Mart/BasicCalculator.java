package Mart;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        System.out.println(calculate("1 + 1")); // Output: 2
        System.out.println(calculate(" 2-1 + 2 ")); // Output: 3
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)")); // Output: 23
    }

    private static int calculate(String s) {
        int num=0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10+(ch-'0');
            } else if (ch == '+') {
                result =result+sign*num;
                num=0;
                sign=1;
            } else if (ch == '-') {
                result = result+sign*num;
                num=0;
                sign=-1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign=1;
                result = 0;
            }else if(ch == ')'){
                result = result+sign*num;
                result = result*stack.pop();
                result = result+stack.pop();
                num = 0;
            }
        }
        return result + (sign * num);
    }
}
