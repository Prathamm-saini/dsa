package basics.BitManipulation;

public class CheckIthBitSetOrNot {
    public static void main(String[] args) {
        System.out.println(checkIthBitSetOrNotBrute(new StringBuilder("10110101"),3));
        System.out.println(checkIthBitSetOrNot(13,3));
    }
    private static boolean checkIthBitSetOrNotBrute(StringBuilder str,int i){
        int index = str.length()-1-i;
        char bit = str.charAt(index);
        return bit == '1';
    }
    private static boolean checkIthBitSetOrNot(int n,int i){
        int result = n & (1 << i);
        return result != 0;
    }
}
