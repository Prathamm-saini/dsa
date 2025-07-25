package basics.strings;


import java.util.ArrayList;
import java.util.Arrays;

public class questions {
    public static void main(String[] args) {
        String[] arr = {"Prat","Sai","Arrow","Dam"};
        StringArrayPrinting(arr);

    }
    // for any string s of length n, no of substring = (n(n+1))/2 + 1("") empty substring
    static ArrayList<String> printAllSubstring(String s){
        ArrayList<String> list = new ArrayList<>();
        for (int start = 0; start <s.length(); start++) {
            for (int end = start; end <s.length(); end++) { // end = start coz want one character word too
                list.add(s.substring(start,end+1));
            }
        }
        list.add(""+"(empty space)");
        return list;
        // Time Complexity -> o(n square)
    }
    static String reverseString(String s){
        String compute ="";
        for(int i =s.length()-1;i>=0;i--){
            compute += s.charAt(i);
        }
        return compute;
        // if you want to modify and return the sam string use StringBuilder or StringBuffer
    }
    // 2nd way
    static StringBuilder reverseString2(StringBuilder input){
        StringBuilder result = new StringBuilder(input);
        for (int i = 0; i <input.length()/2; i++) {
            char firstChar = input.charAt(i);
            char  lastChar = input.charAt(input.length()-i-1);
            result.setCharAt(i,lastChar);
            result.setCharAt(input.length()-1-i,firstChar);
        }
        return  result;
    }
    static boolean isPalindrome(String s){
        return reverseString(s).equals(s);
    }
    static void StringArrayPrinting(String[] stringArray){
        for(int i=0;i<stringArray.length;i++){
            System.out.println(stringArray[i]);
        }
    }
}
