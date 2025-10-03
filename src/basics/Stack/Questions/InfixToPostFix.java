package basics.Stack.Questions;

import java.util.Stack;

public class InfixToPostFix {
    public static void main(String[] args) {
        String s = "a+b*(c^d-e)";
        System.out.println(infixToPostFix(s));
    }
    // Precedence function
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }
    public static String infixToPostFix(String s) {
       Stack<Character> stack = new Stack<>();
       StringBuilder ans = new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9'){
                ans.append(ch);
            }
            else if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')'){
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans.append(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }
            else{
                while(!stack.isEmpty()  && precedence(ch) <= precedence(stack.peek())){
                    ans.append(stack.pop());
                }
                // executes everytime
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
