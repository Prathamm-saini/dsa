package basics.Recursion;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String name  = "abc";
        printSubSeq("",name);
        ArrayList<String> list = new ArrayList<>();
        System.out.println(printSubSeq("","MNO",list));
        System.out.println(printSubSeq2("","Pratham"));
        printSubSeqAscii("","ab");

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
    private static ArrayList<String> printSubSeq(String processed,String unprocessed,ArrayList<String> list){
        if(unprocessed.isEmpty()){
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        printSubSeq(processed + ch,unprocessed.substring(1),list);
        printSubSeq(processed,unprocessed.substring(1),list);

        return list;
    }
    private static ArrayList<String> printSubSeq2(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> taken =  printSubSeq2(processed +ch,unprocessed.substring(1));
        ArrayList<String> notTaken =  printSubSeq2(processed,unprocessed.substring(1));

        taken.addAll(notTaken);
        return taken;
    }
    private static void printSubSeqAscii(String processed,String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);
        printSubSeqAscii(processed + ch,unprocessed.substring(1));
        printSubSeqAscii(processed,unprocessed.substring(1));
        printSubSeqAscii(processed+(int)ch,unprocessed.substring(1));
    }
}
