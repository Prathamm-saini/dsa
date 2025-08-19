package basics.bigIntegerHandling;

import java.math.BigInteger;

/*
*  Storing Large Integers in Java
*
* 1.BigInteger class
*    It is present in Object class under java.lang.Numbers where you get "java.Math.BigInteger"
*
* 2.It extends Number class and implements comparable<Big Integer> interface
*
* 3.Range
*  -2^Integer.MAX_VALUE - 2^Integer.MAX_VALUE
*  these values are both exclusive,you can't use these bounds
*
*
*
*
*
*
*
*
*
* */
public class bigInteger {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        BigInteger A = BigInteger.valueOf(411005555); // it can convert int/long to BigInteger
        // Internally it just creates a comparable long in memory and creates a BigInteger
        // using .valueOf .It has some range if we go overboard it will throw an error
        BigInteger B = BigInteger.valueOf(432111);

        System.out.println(A.add(B)); // we can't directly add them as they are objects
        System.out.println(A.subtract(B));
        System.out.println(A.multiply(B));
        System.out.println(A.divide(B));
        System.out.println(A.mod(B));

        // BigInteger type data in Strings
        // no matter how large a number is just pass it in a string
        BigInteger D = new BigInteger("1097366261234422234444");
        // we cannot use valueOf operator for strings
        System.out.println(D);


        /// BigInteger conversion to int
        int e = D.intValue();
        System.out.println(e);

        Factorial factorial = new Factorial();
        System.out.println(Factorial.factorial(55555));
    }
}

class Factorial{
   static BigInteger factorial(int n){
       BigInteger res = new BigInteger("1");
       for (int i = 2; i <=n; i++) {
           res = res.multiply(BigInteger.valueOf(i));
       }
       return res;
   }
}