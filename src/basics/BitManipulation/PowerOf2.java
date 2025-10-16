package basics.BitManipulation;

public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(isPowerOf2(1024));
    }
    private static boolean isPowerOf2(int n){
        int result = n & (n-1);
        return result == 0;
    }
}
