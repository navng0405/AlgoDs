package Mart;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1] Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval)
 * I/p: ‘3+2*2”
 * O/p:7.. Give me code in java
 */
public class EvaluvateExpre {
    public static void main(String[] args) {
        String expr = "34+2*2";
        System.out.println(calculate(expr));
    }

    private static Integer calculate(String expr){
        Stack<Integer> stack = new Stack<>();
        int currentValue = 0;
        char operation = '+';
        for(int i=0;i<expr.length();i++){
            char currentChar = expr.charAt(i);
            if(Character.isDigit(expr.charAt(i))){
                currentValue = currentValue*10+currentChar-'0';
            }
            if(!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == expr.length()-1){
                if( operation == '-'){
                    stack.push(-currentValue);
                }else if(operation == '+'){
                    stack.push(currentValue);
                }else if(operation == '*'){
                    stack.push(stack.pop()*currentValue);
                }else if(operation =='/'){
                    stack.push(stack.pop()/currentValue);
                }

                operation = currentChar;
                currentValue = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
