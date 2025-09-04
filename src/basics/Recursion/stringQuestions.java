package basics.Recursion;

public class stringQuestions {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aabccabcad");
        System.out.println(remove(sb,'a'));
        System.out.println(removeChar(sb,'a'));
        System.out.println(recursiveRemoveChar(sb,'a',new StringBuilder(""),0));

        StringBuilder sb1 = new StringBuilder("abbbbbbbabccabcad");
        System.out.println(recursiveRemoveChar(sb1,0));

        String APPLE = "appleappleorange";
        System.out.println(skipApple(APPLE));

        String SkipApp = "appleapp";
        System.out.println(skipAppNotApple(SkipApp));

    }
    // remove a particular character from a string
    private static StringBuilder remove(StringBuilder sb,char c ) {
        for (int i = 0; i <sb.length(); i++) {
            if (sb.charAt(i) == c) {
                sb.deleteCharAt(i);
                i--; // to check again if duplicate same char like aa 'i' moves ahead and a moves at 0
                // which leaves to check this a which are together so with this trick check again
            }
        }
        return sb;
    }
    // what if you do not want to use delete func
    private static StringBuilder removeChar(StringBuilder sb,char c) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != c) {
                result.append(sb.charAt(i));
            }
        }
        return result;
    }
    /// Recursive way and the SUBSET PROBLEM
    private static StringBuilder recursiveRemoveChar(StringBuilder sb,char c,StringBuilder ans,int index) {
       if(index == sb.length()){
           return ans;
       }
       char current =  sb.charAt(index);

       if(current != c) {
           ans.append(current);
       }
       return recursiveRemoveChar(sb,c,ans,index+1);
    }
    private static String recursiveRemoveChar(StringBuilder sb,int index) {
        if(sb.length() == index){
            return "";
        }
        char current = sb.charAt(index);
        if(current != 'a'){
            return current + recursiveRemoveChar(sb,index+1);
        }
        return recursiveRemoveChar(sb,index+1);
    }
    private static String skipApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("apple")){
            return s.replace("apple","");
        }
        return s.charAt(0) + skipApple(s.substring(1));
    }
    private static String skipAppNotApple(String s){
        if(s.isEmpty()){
            return "";
        }
        if(s.startsWith("app") && !s.startsWith("apple")){
            return s.replace("app","");
        }
        return s.charAt(0) + skipAppNotApple(s.substring(1));
    }

}
