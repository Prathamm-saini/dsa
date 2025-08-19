package basics.bigIntegerHandling;
/// BigDecimal. Object class -> java.lang.Numbers -> java.math.BigDecimal.
/// BigDecimal extends Numbers and implements Comparable<BigDecimal>
/// IT contains a random precision . scale is a 32-bit integer
///n>0 scales is equal to no of digits rights of decimal point otherwise the unscale value is 10^-scale
import java.math.BigDecimal;
public class bigDecimal {
    public static void main(String[] args) {
        BD();
    }
    static void BD(){
        double a = 0.03;
        double b = 0.01;
        System.out.println(a-b); // It should be 0.01
        // it is returning 0.01999999997 but why?
        // Because float and decimals/double  are floating point numbers
        // binary representation of a fraction and an exponent
        // while integers are fixed
        // therefore there is a little bit of error in handling double

        // always pass value in strings for BigDecimal and BigInteger
        BigDecimal bd = new BigDecimal("0.04");
        BigDecimal bd1 = new BigDecimal("0.03");
        System.out.println(bd.subtract(bd1));
        // here it gives exact 0.01

        System.out.println(bd.multiply(bd1));
        System.out.println(bd.divide(bd1,2,BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.multiply(bd1));


    }
}
