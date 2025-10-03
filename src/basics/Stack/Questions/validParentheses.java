package basics.Stack.Questions;

import java.util.Stack;

public class validParentheses {
    public static void main(String[] args) {

    }
    public static boolean ValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length()-1; i++) {
            if(s.charAt(i) == '(' || s.charAt(i)== '{' || s.charAt(i) =='['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(s.charAt(i) == ')' && top != '('){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
