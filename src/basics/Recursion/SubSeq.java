package basics.Recursion;

public class SubSeq {
    public static void main(String[] args) {
        String name  = "abc";
        printSubSeq("",name);


    }
    private static void printSubSeq(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);

        /// take it
        printSubSeq(processed + ch,unprocessed.substring(1));
        /// do not take it
        printSubSeq(processed,unprocessed.substring(1));
    }
}
