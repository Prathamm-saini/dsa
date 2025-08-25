package basics.Recursion;

import java.io.PrintStream;

public class Level1 {
    public static void main(String[] args) {
        PrintNto1(10);
        System.out.println();
        Print1toN(1);
        System.out.println();
        Print1toN2ndWay(10);
        System.out.println();
        PrintBoth(10);
        System.out.println();
        System.out.println(productFromNto1(5));
        System.out.println(sumFromNto1(10));
        System.out.println(sumOfDigitsIterative(1111));
        System.out.println(productOfDigitsIterative(1111));
        System.out.println(sumOfDigitsRecursive(125));
        System.out.println(productOfDigitsRecursive(125));
        reversalIterative(123);
        System.out.println(reversalRecursive(123,0));
    }
    static void PrintNto1(int n){
        if(n < 1){
            return;
        }
        System.out.print(n+" ");
        PrintNto1(n-1);
    }
    static void Print1toN(int n){
        // n passed as 1
        if(n == 10){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        Print1toN(++n);
    }
    static void Print1toN2ndWay(int n){
        // n passed as n itself
        if(n < 1){
            return;
        }
        Print1toN2ndWay(n-1);
        System.out.print(n+" ");

    }
    static void PrintBoth(int n){
        if(n == 0) return;
        System.out.print(n+" ");
        PrintBoth(n-1);
        System.out.print(n+" ");
    }
    static int productFromNto1(int n){
        if(n == 1) return 1;
        return n * productFromNto1(n-1);
    }
    static int sumFromNto1(int n){
        if(n == 1) return 1;
        return n + sumFromNto1(n-1);
    }
    static void reversalIterative(int n){
        int num = 0;
        while(n>0){
            int digit = n % 10;
            num = num*10 + digit;
            n = n / 10;
        }
        System.out.println(num);
    }
    static int reversalRecursive(int n,int rev){
        if(n == 0) return rev;
        int digit = n % 10;
        rev = rev*10 + digit;
        return reversalRecursive(n/10,rev);
    }
    static int sumOfDigitsIterative(int n){
        int sum = 0;
        while(n>0){
            int digit = n % 10;
            sum = sum + digit;
            n = n / 10;
        }
        return sum;
    }
    static int sumOfDigitsRecursive(int n){
        if(n == 0) return 0;
        int digit = n % 10;
        return digit + sumOfDigitsRecursive(n/10);
    }
    static int productOfDigitsIterative(int n){
        int product = 1;
        while(n>0){
            int digit = n % 10;
            product *= digit;
            n = n / 10;
        }
        return product;
    }
    static int productOfDigitsRecursive(int n){
        if(n ==1) return 1;
        int digit = n % 10;
        return digit * productOfDigitsRecursive(n/10);
    }
}
