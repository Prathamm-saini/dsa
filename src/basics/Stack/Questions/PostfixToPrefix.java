package basics.Stack.Questions;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String str = "AB-DE+F*/";
        System.out.println(prefixToPostfix(str));
    }
    public static String prefixToPostfix(String str){
        Stack<String> stack = new Stack<>();
        for (int i = 0; i <str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                stack.push(ch+"");
            }
            else{
                String top1 = stack.pop();
                String top2 = stack.pop();
                String newString = ch+top2+top1;
                stack.push(newString);
            }
        }
        return stack.pop();
    }
}
