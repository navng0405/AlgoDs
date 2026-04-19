package StringProbs;

import java.util.Stack;

/**
 * Initialize stack,
 * int start= 0
 * iterate givenString
 *         check char[i] == " "
 *             while(stack is not empty
 *                  pop stack to add back to char array
 *          else
 *             push to stack
 *
 *if stack is not empty
 *    while(stack is not empty & start>char.length)
 *          pop to stack
 *
 *
 */
public class ReverseWords {
    public static void main(String args[]){
        System.out.println(reverString("moo cow bark dog"));
    }

    public static String reverString(String givenString) {
        Stack<Character> stack = new Stack<>();
        int start =0;
        char[] chars = givenString.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == ' '){
                while(!stack.isEmpty()){
                    chars[start++] = stack.pop();
                }
                start = start+1;
            }else{
                stack.push(chars[i]);
            }
        }

        while(!stack.isEmpty() && start< chars.length){
            chars[start++] = stack.pop();
        }

        return new String(chars);
    }
}

