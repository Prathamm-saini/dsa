package basics.Recursion;

public class subset {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("aabccabcad");
        System.out.println(remove(sb,'a'));
        System.out.println(removeChar(sb,'a'));
        System.out.println(recursiveRemoveChar(sb,'a',new StringBuilder(""),0));
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

}
