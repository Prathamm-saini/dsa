package basics.Stack.Questions;

import java.util.Stack;

public class infixToPrefix {
    public static void main(String[] args) {
        String str = "(A+B)*C-D+F";
        System.out.println(InfixToPreFix(str));
    }
    public static String InfixToPreFix(String s) {
        // Step 1  -> reverse the string
        String reverse = reverse(s);

        // Step 2 swap brackets
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i <reverse.length(); i++) {
            if(reverse.charAt(i)=='('){
                newString.append(')');
            }
            else if(reverse.charAt(i)==')'){
                newString.append('(');
            }
            else{
                newString.append(reverse.charAt(i));
            }
        }
        StringBuilder finalString = infixToPostFixWithConditionalChange(newString);
        return finalString.reverse().toString();
    }
    public static String reverse(String s){
        int low = 0;
        int high = s.length()-1;
        char[] arr = s.toCharArray();
        while(low<high){
            char temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(arr);
    }
    public static StringBuilder infixToPostFixWithConditionalChange(StringBuilder s){
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
                stack.push(ch);
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans;
    }

}
