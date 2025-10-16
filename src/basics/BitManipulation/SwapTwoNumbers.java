package basics.BitManipulation;

/*
        XOR of same number is 0 and XOR of number ^ 0 = number
        XOR of no1 and no2 is some number no3
 */

public class SwapTwoNumbers {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("Before Swapping : "+a+"   "+b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("After Swapping  : "+a+"   "+b);
    }
}
