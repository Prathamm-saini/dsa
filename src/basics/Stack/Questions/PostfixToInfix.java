package basics.Stack.Questions;

import java.sql.SQLOutput;
import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String Postfix = "AB-DE+F*/";
        System.out.println(postfixToInfix(Postfix));
    }
    public static String postfixToInfix(String postfix){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String newString = "("+top2+" "+ch+" "+top1+")";
                stack.push(newString);
            }
        }
        return stack.pop();
    }
}
