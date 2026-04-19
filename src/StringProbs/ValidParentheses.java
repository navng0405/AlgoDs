package StringProbs;

import java.util.Stack;
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "(){}[]";
        System.out.println("Is Valid ? "+ isValid(input));
    }

    private static boolean isValid(String string){
        Stack<Character> stack = new Stack<>();
        for(char ch : string.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                if((ch == ')' && stack.peek() != '(') || (ch == '}' && stack.peek() != '{') || (ch == ']' && stack.peek() != '[')){
                    return false;
                }

                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
