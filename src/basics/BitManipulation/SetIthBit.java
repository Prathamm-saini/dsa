package basics.BitManipulation;

public class SetIthBit {
    public static void main(String[] args) {
        System.out.println(setIthBitBrute(new StringBuilder("10110"),3));
        System.out.println(setIthBit(13,1));
    }
    private static StringBuilder setIthBitBrute(StringBuilder str,int i){
        int index =  str.length()-1-i;
        if(str.charAt(index)=='0'){
            str.setCharAt(index,'1');
        }
        return str;
    }
    private static int setIthBit(int n,int i){
        return n | (1 << i);
    }
}
