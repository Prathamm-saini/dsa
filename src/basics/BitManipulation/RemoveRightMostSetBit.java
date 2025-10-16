package basics.BitManipulation;

public class RemoveRightMostSetBit {
    public static void main(String[] args) {
        System.out.println(removeRightMostSetBit(12));
    }
    // Pattern Problem
    private static int  removeRightMostSetBit(int n){
        return n & n-1;
    }
}
