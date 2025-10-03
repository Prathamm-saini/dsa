package basics.Stack.Questions;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String str = "/-AB*+DEF";
        System.out.println(prefixToPostfix(str));
    }
    public static String prefixToPostfix(String str){
        Stack<String> stack = new Stack<>();
        for (int i = str.length()-1; i>=0 ; i--) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String newString = top1+top2+ch;
                stack.push(newString);
            }
        }
        return stack.pop();
    }
}
