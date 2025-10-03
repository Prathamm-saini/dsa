package basics.Stack.Questions;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String str = "*+PQ-MN";
        System.out.println(prefixToInfix(str));
    }
    public static String prefixToInfix(String str){
        Stack<String> stack = new Stack<>();
        for (int i = str.length()-1; i >=0 ; i--) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String top3 = "("+top1+ch+top2+")";
                stack.push(top3);
            }
        }
        return stack.pop();
    }
}
